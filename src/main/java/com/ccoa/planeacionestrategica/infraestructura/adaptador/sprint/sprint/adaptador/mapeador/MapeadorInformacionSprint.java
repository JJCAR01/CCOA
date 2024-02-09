package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador.MapeadorDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadInformacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioInformacionSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorInformacionSprint implements MapeadorInfraestructura<EntidadInformacionSprint, InformacionSprint> {
    private final RepositorioInformacionSprintJpa repositorioInformacionSprintJpa;
    private final RepositorioTareaJpa repositorioTareaJpa;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final MapeadorDetalleProyecto mapeadorDetalleProyecto;
    private final MapeadorSprint mapeadorSprint;

    public MapeadorInformacionSprint(RepositorioInformacionSprintJpa repositorioInformacionSprintJpa, RepositorioTareaJpa repositorioTareaJpa,
                                     RepositorioInformacionTareaJpa repositorioInformacionTareaJpa, ServicioObtenerPorcentaje servicioObtenerPorcentaje, MapeadorDetalleProyecto mapeadorDetalleProyecto, MapeadorSprint mapeadorSprint) {
        this.repositorioInformacionSprintJpa = repositorioInformacionSprintJpa;
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.repositorioInformacionTareaJpa = repositorioInformacionTareaJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.mapeadorDetalleProyecto = mapeadorDetalleProyecto;
        this.mapeadorSprint = mapeadorSprint;
    }

    @Override
    public InformacionSprint mapeadorDominio(EntidadInformacionSprint entidad) {
        return new InformacionSprint(entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(), entidad.getPorcentajeCumplimiento());
    }

    @Override
    public EntidadInformacionSprint mapeadorEntidad(InformacionSprint dominio) {
        return new EntidadInformacionSprint(dominio.getPorcentajeReal(), dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento());
    }
    public EntidadInformacionSprint obtenerTodaEntidadSprint(Long idSprint) {
        var entidadInformacionSprint = repositorioInformacionSprintJpa.findById(idSprint);
        return new EntidadInformacionSprint(entidadInformacionSprint.orElseThrow().getPorcentajeReal(),
                entidadInformacionSprint.orElseThrow().getPorcentajeEsperado(),
                entidadInformacionSprint.orElseThrow().getPorcentajeCumplimiento());
    }
    public void actualizarPorcentajeAvance(EntidadInformacionSprint entidad) {
        List<EntidadTarea> sprints = this.repositorioTareaJpa.findByIdASEAndTipoASE(entidad.getIdInformacionSprint(), ETipoASE.SPRINT);
        List<EntidadInformacionTarea> informacionTareasSprint = this.repositorioInformacionTareaJpa.
                findAll()
                .stream()
                .filter(e -> sprints.stream()
                        .anyMatch(actividad -> actividad.getIdTarea().equals(e.getIdInformacionTarea())))
                .toList();

        long totalTareas = sprints.size();
        long tareasTerminadas = sprints.stream().filter(tarea -> tarea.getEstado() == EEstado.TERMINADO).count();

        if (totalTareas > 0) {
            double porcentajesDiferentesATareasUnicaVez = servicioObtenerPorcentaje.obtenerPorcentajesDiferentesATareasUnicaVez(informacionTareasSprint, tareasTerminadas, totalTareas);
            double nuevoAvance = servicioObtenerPorcentaje.obtenerNuevoAvance(tareasTerminadas,porcentajesDiferentesATareasUnicaVez,totalTareas);
            entidad.setPorcentajeReal(nuevoAvance);
            var idProyecto = mapeadorSprint.obtenerIdProyectoRelacionadoConElSprint(entidad.getIdInformacionSprint()).getIdProyecto();
            var proyecto = mapeadorDetalleProyecto.obtenerTodaEntidadProyecto(idProyecto);
            mapeadorDetalleProyecto.actualizarPorcentajeAvance(proyecto,idProyecto);
        }
    }


}
