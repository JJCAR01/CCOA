package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorInformacionActividadGestion implements MapeadorInfraestructura<EntidadInformacionActividadGestion, InformacionActividadGestion> {
    private final RepositorioTareaJpa repositorioTareaJpa;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;
    private final RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final MapeadorInformacionPat mapeadorInformacionPat;
    private final MapeadorActividadGestion mapeadorActividadGestion;

    public MapeadorInformacionActividadGestion(RepositorioTareaJpa repositorioTareaJpa, RepositorioInformacionTareaJpa repositorioInformacionTareaJpa,
                                               RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa,
                                               ServicioObtenerPorcentaje servicioObtenerPorcentaje, MapeadorInformacionPat mapeadorInformacionPat, MapeadorActividadGestion mapeadorActividadGestion) {
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.repositorioInformacionTareaJpa = repositorioInformacionTareaJpa;
        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.mapeadorInformacionPat = mapeadorInformacionPat;
        this.mapeadorActividadGestion = mapeadorActividadGestion;
    }

    @Override
    public InformacionActividadGestion mapeadorDominio(EntidadInformacionActividadGestion entidad) {
        return new InformacionActividadGestion(entidad.getDuracion(), entidad.getDiasRestantes(),entidad.getPorcentajeReal(),
                entidad.getPorcentajeEsperado(),entidad.getPorcentajeCumplimiento());
    }

    @Override
    public EntidadInformacionActividadGestion mapeadorEntidad(InformacionActividadGestion dominio) {
        return new EntidadInformacionActividadGestion(dominio.getDuracion(),dominio.getDiasRestantes(), dominio.getPorcentajeReal(),
                dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento());
    }
    public EntidadInformacionActividadGestion obtenerTodaEntidadActvidadGestion(Long idActividadGestion) {
        var entidadInformacionSprint = repositorioInformacionActividadGestionJpa.findById(idActividadGestion);
        return new EntidadInformacionActividadGestion(
                entidadInformacionSprint.orElseThrow().getIdInformacionActividadGestion(),
                entidadInformacionSprint.orElseThrow().getDuracion(),
                entidadInformacionSprint.orElseThrow().getDiasRestantes(),entidadInformacionSprint.orElseThrow().getPorcentajeReal(),
                entidadInformacionSprint.orElseThrow().getPorcentajeEsperado(),
                entidadInformacionSprint.orElseThrow().getPorcentajeCumplimiento());
    }
    public void actualizarPorcentajeAvance(EntidadInformacionActividadGestion entidad,Long idInformacionActividadGestion) {
        List<EntidadTarea> sprints = this.repositorioTareaJpa.findByIdASEAndTipoASE(idInformacionActividadGestion, ETipoASE.ACTIVIDAD_GESTION);
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
            entidad.setIdInformacionActividadGestion(idInformacionActividadGestion);
            var porcentajeEsperado = servicioObtenerPorcentaje.obtenerPorcentajeEsperado(
                    mapeadorActividadGestion.obtenerIdPatRelacionadoConElActividadGestion(idInformacionActividadGestion).getFechaInicial(), entidad.getDuracion());
            entidad.setPorcentajeEsperado(Math.min(porcentajeEsperado, Mensaje.PORCENTAJE));
            entidad.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(entidad.getPorcentajeReal(),entidad.getPorcentajeEsperado()));
            repositorioInformacionActividadGestionJpa.save(entidad);
            var idPat = mapeadorActividadGestion.obtenerIdPatRelacionadoConElActividadGestion(idInformacionActividadGestion).getIdPat();
            var entidadActividadGestion = mapeadorInformacionPat.obtenerTodaEntidadPat(idPat);
            mapeadorInformacionPat.actualizarPorcentajeAvance(entidadActividadGestion,idPat);
        }
    }

}
