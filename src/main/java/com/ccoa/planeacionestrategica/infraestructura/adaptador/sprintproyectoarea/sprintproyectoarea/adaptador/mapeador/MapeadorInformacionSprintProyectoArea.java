package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.InformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador.MapeadorDetalleProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadInformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa.RepositorioInformacionSprintProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorInformacionSprintProyectoArea implements MapeadorInfraestructura<EntidadInformacionSprintProyectoArea, InformacionSprintProyectoArea> {
    private final RepositorioInformacionSprintProyectoAreaJpa repositorioInformacionSprintProyectoAreaJpa;
    private final RepositorioTareaJpa repositorioTareaJpa;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final MapeadorDetalleProyectoArea mapeadorDetalleProyectoArea;
    private final MapeadorSprintProyectoArea mapeadorSprintProyectoArea;

    public MapeadorInformacionSprintProyectoArea(RepositorioInformacionSprintProyectoAreaJpa repositorioInformacionSprintProyectoAreaJpa, RepositorioTareaJpa repositorioTareaJpa,
                                                 RepositorioInformacionTareaJpa repositorioInformacionTareaJpa, ServicioObtenerPorcentaje servicioObtenerPorcentaje,
                                                 MapeadorDetalleProyectoArea mapeadorDetalleProyectoArea, MapeadorSprintProyectoArea mapeadorSprintProyectoArea) {
        this.repositorioInformacionSprintProyectoAreaJpa = repositorioInformacionSprintProyectoAreaJpa;
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.repositorioInformacionTareaJpa = repositorioInformacionTareaJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.mapeadorDetalleProyectoArea = mapeadorDetalleProyectoArea;
        this.mapeadorSprintProyectoArea = mapeadorSprintProyectoArea;
    }

    @Override
    public InformacionSprintProyectoArea mapeadorDominio(EntidadInformacionSprintProyectoArea entidad) {
        return new InformacionSprintProyectoArea(entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(), entidad.getPorcentajeCumplimiento());
    }

    @Override
    public EntidadInformacionSprintProyectoArea mapeadorEntidad(InformacionSprintProyectoArea dominio) {
        return new EntidadInformacionSprintProyectoArea(dominio.getPorcentajeReal(), dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento());
    }
    public EntidadInformacionSprintProyectoArea obtenerTodaEntidadSprintProyectoArea(Long idSprintProyectoArea) {
        var entidadInformacionSprintProyectoArea = repositorioInformacionSprintProyectoAreaJpa.findById(idSprintProyectoArea);
        return new EntidadInformacionSprintProyectoArea(idSprintProyectoArea,
                entidadInformacionSprintProyectoArea.orElseThrow().getPorcentajeReal(),
                entidadInformacionSprintProyectoArea.orElseThrow().getPorcentajeEsperado(),
                entidadInformacionSprintProyectoArea.orElseThrow().getPorcentajeCumplimiento());
    }
    public void actualizarPorcentajeAvance(EntidadInformacionSprintProyectoArea entidad, Long idSprintProyectoArea) {
        List<EntidadTarea> sprintProyectoAreas = this.repositorioTareaJpa.findByIdASEAndTipoASE(idSprintProyectoArea, ETipoASE.SPRINT_PROYECTO_AREA);
        List<EntidadInformacionTarea> informacionTareasSprintProyectoArea = this.repositorioInformacionTareaJpa.
                findAll()
                .stream()
                .filter(e -> sprintProyectoAreas.stream()
                        .anyMatch(actividad -> actividad.getIdTarea().equals(e.getIdInformacionTarea())))
                .toList();

        long totalTareas = sprintProyectoAreas.size();
        long tareasTerminadas = sprintProyectoAreas.stream().filter(tarea -> tarea.getEstado() == EEstado.TERMINADO).count();

        if (totalTareas > 0) {
            double porcentajesDiferentesATareasUnicaVez = servicioObtenerPorcentaje.obtenerPorcentajesDiferentesATareasUnicaVez(informacionTareasSprintProyectoArea, tareasTerminadas, totalTareas);
            double nuevoAvance = servicioObtenerPorcentaje.obtenerNuevoAvance(tareasTerminadas,porcentajesDiferentesATareasUnicaVez,totalTareas);
            entidad.setPorcentajeReal(nuevoAvance);
            entidad.setIdInformacionSprintProyectoArea(idSprintProyectoArea);
            entidad.setPorcentajeEsperado(entidad.getPorcentajeEsperado());
            entidad.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(entidad.getPorcentajeReal(),entidad.getPorcentajeEsperado()));
            repositorioInformacionSprintProyectoAreaJpa.save(entidad);
            var idProyecto = mapeadorSprintProyectoArea.obtenerIdProyectoRelacionadoConElSprintProyectoArea(idSprintProyectoArea).getIdProyectoArea();
            var proyecto = mapeadorDetalleProyectoArea.obtenerTodaEntidadProyecto(idProyecto);
            mapeadorDetalleProyectoArea.actualizarPorcentajeAvance(proyecto,idProyecto);
        }
    }


}
