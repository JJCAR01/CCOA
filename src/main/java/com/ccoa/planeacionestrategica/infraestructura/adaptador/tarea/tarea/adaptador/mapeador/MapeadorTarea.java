package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoTareaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidad;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.mapeador.MapeadorActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.mapeador.MapeadorActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.mapeador.MapeadorInformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioActividadGestionEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.mapeador.MapeadorInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.mapeador.MapeadorInformacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.mapeador.MapeadorSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorTarea implements MapeadorInfraestructura<EntidadTarea, Tarea> {
    private final RepositorioActividadGestionJpa repositorioActividadGestionJpa;
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadGestionEstrategicaJpa repositorioActividadGestionEstrategicaJpa;
    private final MapeadorInformacionSprint mapeadorInformacionSprint;
    private final MapeadorInformacionActividadGestion mapeadorInformacionActividadGestion;
    private final MapeadorInformacionActividadGestionEstrategica mapeadorInformacionActividadGestionEstrategica;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;

    public MapeadorTarea(RepositorioActividadGestionJpa repositorioActividadGestionJpa,RepositorioSprintJpa repositorioSprintJpa,
                         RepositorioUsuarioJpa repositorioUsuarioJpa,
                         RepositorioActividadGestionEstrategicaJpa repositorioActividadGestionEstrategicaJpa,
                         MapeadorInformacionSprint mapeadorInformacionSprint, MapeadorInformacionActividadGestion mapeadorInformacionActividadGestion,
                         MapeadorInformacionActividadGestionEstrategica mapeadorInformacionActividadGestionEstrategica,
                         RepositorioInformacionTareaJpa repositorioInformacionTareaJpa) {
        this.repositorioActividadGestionJpa = repositorioActividadGestionJpa;
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadGestionEstrategicaJpa = repositorioActividadGestionEstrategicaJpa;
        this.mapeadorInformacionSprint = mapeadorInformacionSprint;
        this.mapeadorInformacionActividadGestion = mapeadorInformacionActividadGestion;
        this.mapeadorInformacionActividadGestionEstrategica = mapeadorInformacionActividadGestionEstrategica;
        this.repositorioInformacionTareaJpa = repositorioInformacionTareaJpa;
    }

    @Override
    public Tarea mapeadorDominio(EntidadTarea entidad) {
        return new Tarea(entidad.getIdTarea(), entidad.getNombre(), entidad.getEstado(), entidad.getDescripcion(), entidad.getTipoASE(), entidad.getIdASE(), entidad.getIdUsuario());
    }

    @Override
    public EntidadTarea mapeadorEntidad(Tarea dominio) {
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        if (dominio.getTipoASE() == ETipoASE.ACTIVIDAD_GESTION) {
            var actividadGestion = this.repositorioActividadGestionJpa.findById(dominio.getIdASE()).orElseThrow().getIdActividadGestion();
            return new EntidadTarea(dominio.getNombre(), dominio.getEstado(), dominio.getDescripcion(),dominio.getTipoASE() ,actividadGestion,usuario);
        } else if (dominio.getTipoASE() == ETipoASE.SPRINT) {
            var sprint = this.repositorioSprintJpa.findById(dominio.getIdASE()).orElseThrow().getIdSprint();
            return new EntidadTarea(dominio.getNombre(), dominio.getEstado(), dominio.getDescripcion(),dominio.getTipoASE() ,sprint,usuario);
        } else if (dominio.getTipoASE() == ETipoASE.ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA) {
            var actGestionaActividadEstrategica = this.repositorioActividadGestionEstrategicaJpa.findById(dominio.getIdASE()).orElseThrow().getIdActividadGestionEstrategica();
            return new EntidadTarea(dominio.getNombre(), dominio.getEstado(), dominio.getDescripcion(),dominio.getTipoASE() ,actGestionaActividadEstrategica,usuario);
        } else {
            return null;
        }
    }


    public List<DtoTareaResumen> listarDominio(List<EntidadTarea> entidades){
        List<DtoTareaResumen> listaDto = new ArrayList<>();
        for (EntidadTarea entidad : entidades) {
            DtoTareaResumen dto = new DtoTareaResumen();
            dto.setIdTarea(entidad.getIdTarea());
            dto.setNombre(entidad.getNombre());
            dto.setEstado(entidad.getEstado().toString());
            dto.setDescripcion(entidad.getDescripcion());
            dto.setTipoAES(entidad.getTipoASE().toString());
            dto.setIdASE(entidad.getIdASE());
            dto.setIdUsuario(entidad.getIdUsuario());

            var informacionTarea = this.repositorioInformacionTareaJpa.findById(entidad.getIdTarea());

            dto.setPeriodicidad(informacionTarea.orElseThrow().getPeriodicidad());
            dto.setPorcentajeReal(informacionTarea.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(informacionTarea.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(informacionTarea.orElseThrow().getPorcentajeCumplimiento());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadTarea entidad, Tarea tarea, EntidadInformacionTarea entidadInformacionTarea,
                                  InformacionTarea informacionTarea){
        entidad.setNombre(tarea.getNombre());
        entidad.setDescripcion(tarea.getDescripcion());
        entidad.setIdUsuario(tarea.getIdUsuario());
        entidadInformacionTarea.setPeriodicidad(informacionTarea.getPeriodicidad());
    }

    private void modificarPorcentajeYEstadoSegunElValorDelPorcentje(EntidadTarea entidadTarea, EntidadInformacionTarea entidadInformacionTarea,
                                                                    InformacionTarea informacionTarea) {
        if(informacionTarea.getPorcentajeReal() == Mensaje.PORCENTAJE){
            entidadTarea.setEstado(EEstado.TERMINADO);
            entidadInformacionTarea.setPorcentajeReal(informacionTarea.getPorcentajeReal());
        }else {
            entidadInformacionTarea.setPorcentajeReal(informacionTarea.getPorcentajeReal());
            entidadTarea.setEstado(EEstado.EN_PROCESO);
        }
    }
    public void actualizarEstadoEntidad(EntidadTarea entidad, Tarea tarea, EntidadInformacionTarea entidadInformacionTarea) {
        entidad.setEstado(tarea.getEstado());
        if(tarea.getEstado() == EEstado.TERMINADO){
            entidadInformacionTarea.setPorcentajeReal(Mensaje.PORCENTAJE);
        } else {
            entidadInformacionTarea.setPorcentajeReal(Mensaje.PORCENTAJE_CERO);
        }
        this.irAEntidadesPadres(entidad.getTipoASE(),entidad);
    }
    public void actualizarPorcentajeEntidad(EntidadTarea entidad, EntidadInformacionTarea entidadInformacionTarea,
                                            InformacionTarea informacionTarea) {
        if(entidadInformacionTarea.getPeriodicidad() != EPeriodicidad.UNICA_VEZ){
            this.modificarPorcentajeYEstadoSegunElValorDelPorcentje(entidad,entidadInformacionTarea,informacionTarea);
            this.irAEntidadesPadres(entidad.getTipoASE(),entidad);
        }
    }

    public void irAEntidadesPadres(ETipoASE tipoSpritOActividadGestionOActividadGestionEstrategica,EntidadTarea entidad) {
        switch (tipoSpritOActividadGestionOActividadGestionEstrategica) {
            case SPRINT -> {
                var sprint = mapeadorInformacionSprint.obtenerTodaEntidadSprint(entidad.getIdASE());
                mapeadorInformacionSprint.actualizarPorcentajeAvance(sprint);
            }
            case ACTIVIDAD_GESTION -> {
                var actividadGestion = mapeadorInformacionActividadGestion.obtenerTodaEntidadActvidadGestion(entidad.getIdASE());
                mapeadorInformacionActividadGestion.actualizarPorcentajeAvance(actividadGestion);
            }
            case ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA -> {
                var actividadGestionEstrategica = mapeadorInformacionActividadGestionEstrategica.obtenerTodaEntidadActvidadGestionEstrategica(entidad.getIdASE());
                mapeadorInformacionActividadGestionEstrategica.actualizarPorcentajeAvance(actividadGestionEstrategica);
            }
        }
    }
}
