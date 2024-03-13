package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.InformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador.MapeadorInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad.EntidadInformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorInformacionActividadGestionEstrategica implements MapeadorInfraestructura<EntidadInformacionActividadGestionEstrategica,
        InformacionActividadGestionEstrategica> {

    private final RepositorioInformacionActividadGestionEstrategicaJpa repositorioInformacionActividadGestionEstrategicaJpa;
    private final RepositorioTareaJpa repositorioTareaJpa;
    private final MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica;
    private final MapeadorActividadGestionEstrategica mapeadorActividadGestionEstrategica;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;

    public MapeadorInformacionActividadGestionEstrategica(RepositorioInformacionActividadGestionEstrategicaJpa repositorioInformacionActividadGestionEstrategicaJpa,
                                                          RepositorioTareaJpa repositorioTareaJpa, MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica, MapeadorActividadGestionEstrategica mapeadorActividadGestionEstrategica, RepositorioInformacionTareaJpa repositorioInformacionTareaJpa, ServicioObtenerPorcentaje servicioObtenerPorcentaje) {
        this.repositorioInformacionActividadGestionEstrategicaJpa = repositorioInformacionActividadGestionEstrategicaJpa;
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.mapeadorInformacionActividadEstrategica = mapeadorInformacionActividadEstrategica;
        this.mapeadorActividadGestionEstrategica = mapeadorActividadGestionEstrategica;
        this.repositorioInformacionTareaJpa = repositorioInformacionTareaJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
    }

    @Override
    public InformacionActividadGestionEstrategica mapeadorDominio(EntidadInformacionActividadGestionEstrategica entidad) {
        return new InformacionActividadGestionEstrategica(entidad.getDuracion(), entidad.getDiasRestantes(),
                entidad.getPorcentajeReal(),entidad.getPorcentajeEsperado(),entidad.getPorcentajeCumplimiento());
    }

    @Override
    public EntidadInformacionActividadGestionEstrategica mapeadorEntidad(InformacionActividadGestionEstrategica dominio) {
        return new EntidadInformacionActividadGestionEstrategica(dominio.getDuracion(),dominio.getDiasRestantes(),
                dominio.getPorcentajeReal(), dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento());
    }

    public EntidadInformacionActividadGestionEstrategica obtenerTodaEntidadActvidadGestionEstrategica(Long idSprint) {
        var entidadInformacionSprint = repositorioInformacionActividadGestionEstrategicaJpa.findById(idSprint);
        return new EntidadInformacionActividadGestionEstrategica(idSprint
                ,entidadInformacionSprint.orElseThrow().getDuracion(),
                entidadInformacionSprint.orElseThrow().getDiasRestantes(),entidadInformacionSprint.orElseThrow().getPorcentajeReal(),
                entidadInformacionSprint.orElseThrow().getPorcentajeEsperado(),
                entidadInformacionSprint.orElseThrow().getPorcentajeCumplimiento());
    }
    public void actualizarPorcentajeAvance(EntidadInformacionActividadGestionEstrategica entidad,Long idInformacionActividadGestionEstrategica) {
        List<EntidadTarea> sprints = this.repositorioTareaJpa.findByIdASEAndTipoASE(idInformacionActividadGestionEstrategica, ETipoASE.ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA);
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
            entidad.setIdInformacionActividadGestionEstrategica(idInformacionActividadGestionEstrategica);
            entidad.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(entidad.getPorcentajeReal(),entidad.getPorcentajeEsperado()));
            entidad.setPorcentajeEsperado(entidad.getPorcentajeEsperado());
            entidad.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(entidad.getPorcentajeReal(),entidad.getPorcentajeEsperado()));
            repositorioInformacionActividadGestionEstrategicaJpa.save(entidad);
            var idActividadEstrategica = mapeadorActividadGestionEstrategica.obtenerIdProyectoRelacionadoConElSprint(idInformacionActividadGestionEstrategica).getIdActividadEstrategica();
            var entidadActividad = mapeadorInformacionActividadEstrategica.obtenerTodaEntidadActividadEstrategica(idActividadEstrategica);
            mapeadorInformacionActividadEstrategica.actualizarPorcentajeAvance(entidadActividad,idActividadEstrategica);
        }
    }

}
