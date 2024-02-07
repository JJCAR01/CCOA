package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentajeAvance;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.pat.adaptador.mapeador.MapeadorPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.repositorio.jpa.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorInformacionActividadGestion implements MapeadorInfraestructura<EntidadInformacionActividadGestion, InformacionActividadGestion> {
    private final RepositorioTareaJpa repositorioTareaJpa;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;
    private final ServicioObtenerPorcentajeAvance servicioObtenerPorcentajeAvance;
    private final MapeadorPat mapeadorPat;
    private final MapeadorActividadGestion mapeadorActividadGestion;

    public MapeadorInformacionActividadGestion(RepositorioTareaJpa repositorioTareaJpa, RepositorioInformacionTareaJpa repositorioInformacionTareaJpa, ServicioObtenerPorcentajeAvance servicioObtenerPorcentajeAvance, MapeadorPat mapeadorPat, MapeadorActividadGestion mapeadorActividadGestion) {
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.repositorioInformacionTareaJpa = repositorioInformacionTareaJpa;
        this.servicioObtenerPorcentajeAvance = servicioObtenerPorcentajeAvance;
        this.mapeadorPat = mapeadorPat;
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

    public void actualizarPorcentajeAvance(EntidadInformacionActividadGestion entidad, InformacionActividadGestion actividadGestion) {
        /*List<EntidadTarea> actividades = this.repositorioTareaJpa.findByIdASEAndTipoASE(actividadGestion.getIdInformacionActividad(), ETipoASE.ACTIVIDAD_GESTION);
        List<EntidadInformacionTarea> informacionTareas = this.repositorioInformacionTareaJpa.
                findAll()
                .stream()
                .filter(e -> actividades.stream()
                        .anyMatch(actividad -> actividad.getIdTarea().equals(e.getIdInformacionTarea())))
                .toList();

        long totalActividades = actividades.size();
        long tareasTerminadas = actividades.stream().filter(tarea -> tarea.getEstado() == EEstado.TERMINADO).count();

        if (totalActividades > 0) {
            double porcentajesDiferentesATareasUnicaVez = servicioObtenerPorcentajeAvance.obtenerPorcentajesDiferentesATareasUnicaVez(informacionTareas, tareasTerminadas, totalActividades);
            double nuevoAvance = servicioObtenerPorcentajeAvance.obtenerNuevoAvance(tareasTerminadas,porcentajesDiferentesATareasUnicaVez,totalActividades);
            entidad.setAvance(nuevoAvance);
            mapeadorPat.actualizarPorcentajeAvance(mapeadorActividadGestion.obtenerGestion(entidad));
        }*/
    }
}
