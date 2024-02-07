package com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoTareaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EPeriodicidad;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.mapeador.MapeadorInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.entidad.EntidadActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.mapeador.MapeadorActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.repositorio.jpa.RepositorioActividadGestionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.mapeador.MapeadorSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.repositorio.jpa.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorTarea implements MapeadorInfraestructura<EntidadTarea, Tarea> {
    private final RepositorioActividadGestionJpa repositorioActividadGestionJpa;
    private final RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadGestionActividadEstrategicaJpa repositorioActividadGestionActividadEstrategicaJpa;
    private final MapeadorSprint mapeadorSprint;
    private final MapeadorInformacionActividadGestion mapeadorInformacionActividadGestion;
    private final MapeadorActividadGestionActividadEstrategica mapeadorActividadGestionActividadEstrategica;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;

    public MapeadorTarea(RepositorioActividadGestionJpa repositorioActividadGestionJpa, RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa, RepositorioSprintJpa repositorioSprintJpa, RepositorioUsuarioJpa repositorioUsuarioJpa,
                         RepositorioActividadGestionActividadEstrategicaJpa repositorioActividadGestionActividadEstrategicaJpa, MapeadorSprint mapeadorSprint, MapeadorInformacionActividadGestion mapeadorInformacionActividadGestion,
                         MapeadorActividadGestionActividadEstrategica mapeadorActividadGestionActividadEstrategica, RepositorioInformacionTareaJpa repositorioInformacionTareaJpa) {
        this.repositorioActividadGestionJpa = repositorioActividadGestionJpa;
        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadGestionActividadEstrategicaJpa = repositorioActividadGestionActividadEstrategicaJpa;
        this.mapeadorSprint = mapeadorSprint;
        this.mapeadorInformacionActividadGestion = mapeadorInformacionActividadGestion;
        this.mapeadorActividadGestionActividadEstrategica = mapeadorActividadGestionActividadEstrategica;
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
            var actGestionaActividadEstrategica = this.repositorioActividadGestionActividadEstrategicaJpa.findById(dominio.getIdASE()).orElseThrow().getIdActividadGestionActividadEstrategica();
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
            dto.setPorcentaje(informacionTarea.orElseThrow().getPorcentaje());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEstadoEntidad(EntidadTarea entidad, Tarea tarea, EntidadInformacionTarea entidadInformacionTarea) {
        entidad.setEstado(tarea.getEstado());
        if(tarea.getEstado() == EEstado.TERMINADO){
            entidadInformacionTarea.setPorcentaje(Mensaje.PORCENTAJE);
        } else {
            entidadInformacionTarea.setPorcentaje(Mensaje.PORCENTAJE_CERO);
        }

        if (entidad.getTipoASE() == ETipoASE.SPRINT) {
            EntidadSprint entidadSprint = obtenerSprintRelacionado(entidad.getIdASE());
            if (entidadSprint != null) {
                Sprint sprint = obtenerSprintDesdeEntidadSprint(entidadSprint);
                mapeadorSprint.actualizarPorcentajeAvance(entidadSprint, sprint);
            }
        } else if (entidad.getTipoASE() == ETipoASE.ACTIVIDAD_GESTION) {
            EntidadInformacionActividadGestion entidadInformacionActividadGestion = obtenerActividadGestionRelacionado(entidad.getIdASE());
            if (entidadInformacionActividadGestion != null) {
                InformacionActividadGestion actividadGestion = obtenerActividadGestionDesdeEntidadActividadGestion(entidadInformacionActividadGestion);
                mapeadorInformacionActividadGestion.actualizarPorcentajeAvance(entidadInformacionActividadGestion, actividadGestion);
            }
        } else if (entidad.getTipoASE() == ETipoASE.ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA){
            EntidadActividadGestionActividadEstrategica entidadInformacionActividadGestion = obtenerActividadGestionActividadEstrategicaRelacionado(entidad.getIdASE());
            if (entidadInformacionActividadGestion != null) {
                ActividadGestionActividadEstrategica actividadGestionActividadEstrategica = obtenerActividadGestionActividadEstrategicaDesdeEntidadActividadGestionActividadEstrategica(entidadInformacionActividadGestion);
                mapeadorActividadGestionActividadEstrategica.actualizarPorcentajeAvance(entidadInformacionActividadGestion, actividadGestionActividadEstrategica);
            }
        }
    }
    public void actualizarPorcentajeEntidad(EntidadTarea entidadTarea, EntidadInformacionTarea entidadInformacionTarea,
                                            InformacionTarea informacionTarea) {
        if(entidadInformacionTarea.getPeriodicidad() != EPeriodicidad.UNICA_VEZ){
            this.modificarPorcentajeYEstadoSegunElValorDelPorcentje(entidadTarea,entidadInformacionTarea,informacionTarea);
            if (entidadTarea.getTipoASE() == ETipoASE.SPRINT) {
                EntidadSprint entidadSprint = obtenerSprintRelacionado(entidadTarea.getIdASE());
                if (entidadSprint != null) {
                    Sprint sprint = obtenerSprintDesdeEntidadSprint(entidadSprint);
                    mapeadorSprint.actualizarPorcentajeAvance(entidadSprint, sprint);
                }
            } else if (entidadTarea.getTipoASE() == ETipoASE.ACTIVIDAD_GESTION) {
                EntidadInformacionActividadGestion entidadInformacionActividadGestion = obtenerActividadGestionRelacionado(entidadTarea.getIdASE());
                if (entidadInformacionActividadGestion != null) {
                    InformacionActividadGestion actividadGestion = obtenerActividadGestionDesdeEntidadActividadGestion(entidadInformacionActividadGestion);
                    mapeadorInformacionActividadGestion.actualizarPorcentajeAvance(entidadInformacionActividadGestion, actividadGestion);
                }
            } else if (entidadTarea.getTipoASE() == ETipoASE.ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA){
                EntidadActividadGestionActividadEstrategica entidadInformacionActividadGestion = obtenerActividadGestionActividadEstrategicaRelacionado(entidadTarea.getIdASE());
                if (entidadInformacionActividadGestion != null) {
                    ActividadGestionActividadEstrategica actividadGestionActividadEstrategica = obtenerActividadGestionActividadEstrategicaDesdeEntidadActividadGestionActividadEstrategica(entidadInformacionActividadGestion);
                    mapeadorActividadGestionActividadEstrategica.actualizarPorcentajeAvance(entidadInformacionActividadGestion, actividadGestionActividadEstrategica);
                }
            }
        }
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
        if(informacionTarea.getPorcentaje() == Mensaje.PORCENTAJE){
            entidadTarea.setEstado(EEstado.TERMINADO);
            entidadInformacionTarea.setPorcentaje(informacionTarea.getPorcentaje());
        }else {
            entidadInformacionTarea.setPorcentaje(informacionTarea.getPorcentaje());
            entidadTarea.setEstado(EEstado.EN_PROCESO);
        }
    }
    private EntidadInformacionActividadGestion obtenerActividadGestionRelacionado(Long id) {
        return this.repositorioInformacionActividadGestionJpa.findById(id).orElseThrow();
    }
    private InformacionActividadGestion obtenerActividadGestionDesdeEntidadActividadGestion(EntidadInformacionActividadGestion actividadGestion) {
        /*return new InformacionActividadGestion(actividadGestion.getIdInformacionActividadGestion(), actividadGestion.getFechaRegistro(),actividadGestion.getDiasRestantes(),
                actividadGestion.getDuracion(),actividadGestion.getAvance());*/
        return null;
    }
    private EntidadSprint obtenerSprintRelacionado(Long id) {
        return this.repositorioSprintJpa.findById(id).orElseThrow();
    }
    private Sprint obtenerSprintDesdeEntidadSprint(EntidadSprint entidadSprint) {
        return new Sprint(entidadSprint.getIdSprint(), entidadSprint.getDescripcion(), entidadSprint.getFechaInicial(), entidadSprint.getFechaFinal(),
                entidadSprint.getAvance(), entidadSprint.getEstado(), entidadSprint.getIdProyecto());
    }
    private EntidadActividadGestionActividadEstrategica obtenerActividadGestionActividadEstrategicaRelacionado(Long id) {
        return this.repositorioActividadGestionActividadEstrategicaJpa.findById(id).orElseThrow();
    }
    private ActividadGestionActividadEstrategica obtenerActividadGestionActividadEstrategicaDesdeEntidadActividadGestionActividadEstrategica
            (EntidadActividadGestionActividadEstrategica entidadActividadGestionActividadEstrategica) {
        /*return new ActividadGestionActividadEstrategica(entidadActividadGestionActividadEstrategica.getIdActividadGestionActividadEstrategica(),
                entidadActividadGestionActividadEstrategica.getNombre(), entidadActividadGestionActividadEstrategica.getFechaInicial(),
                entidadActividadGestionActividadEstrategica.getFechaFinal(), entidadActividadGestionActividadEstrategica.getAvance(),
                entidadActividadGestionActividadEstrategica.getIdUsuario(), entidadActividadGestionActividadEstrategica.getIdActividadEstrategica());+*/
        return null;
    }
}
