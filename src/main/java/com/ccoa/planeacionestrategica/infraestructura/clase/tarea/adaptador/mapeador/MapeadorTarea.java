package com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoTareaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.mapeador.MapeadorInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.entidad.EntidadInformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.mapeador.MapeadorInformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.repositorio.jpa.RepositorioActividadGestionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.mapeador.MapeadorSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
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
    private final MapeadorInformacionActividadGestionActividadEstrategica mapeadorInformacionActividadGestionActividadEstrategica;
    private final RepositorioInformacionActividadGestionActividadEstrategicaJpa repositorioInformacionActividadGestionActividadEstrategicaJpa;

    public MapeadorTarea(RepositorioActividadGestionJpa repositorioActividadGestionJpa, RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa, RepositorioSprintJpa repositorioSprintJpa, RepositorioUsuarioJpa repositorioUsuarioJpa,
                         RepositorioActividadGestionActividadEstrategicaJpa repositorioActividadGestionActividadEstrategicaJpa, MapeadorSprint mapeadorSprint, MapeadorInformacionActividadGestion mapeadorInformacionActividadGestion, MapeadorInformacionActividadGestionActividadEstrategica mapeadorInformacionActividadGestionActividadEstrategica, RepositorioInformacionActividadGestionActividadEstrategicaJpa repositorioInformacionActividadGestionActividadEstrategicaJpa) {
        this.repositorioActividadGestionJpa = repositorioActividadGestionJpa;
        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadGestionActividadEstrategicaJpa = repositorioActividadGestionActividadEstrategicaJpa;

        this.mapeadorSprint = mapeadorSprint;
        this.mapeadorInformacionActividadGestion = mapeadorInformacionActividadGestion;
        this.mapeadorInformacionActividadGestionActividadEstrategica = mapeadorInformacionActividadGestionActividadEstrategica;
        this.repositorioInformacionActividadGestionActividadEstrategicaJpa = repositorioInformacionActividadGestionActividadEstrategicaJpa;
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
            return new EntidadTarea(dominio.getNombre(), dominio.getEstado(), dominio.getObservacion(),dominio.getTipoASE() ,actividadGestion,usuario);
        } else if (dominio.getTipoASE() == ETipoASE.SPRINT) {
            var sprint = this.repositorioSprintJpa.findById(dominio.getIdASE()).orElseThrow().getIdSprint();
            return new EntidadTarea(dominio.getNombre(), dominio.getEstado(), dominio.getObservacion(),dominio.getTipoASE() ,sprint,usuario);
        } else if (dominio.getTipoASE() == ETipoASE.ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA) {
            var actGestionaActividadEstrategica = this.repositorioActividadGestionActividadEstrategicaJpa.findById(dominio.getIdASE()).orElseThrow().getIdActividadGestionActividadEstrategica();
            return new EntidadTarea(dominio.getNombre(), dominio.getEstado(), dominio.getObservacion(),dominio.getTipoASE() ,actGestionaActividadEstrategica,usuario);
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

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadTarea entidad, Tarea tarea) {
        entidad.setEstado(tarea.getEstado());
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
            EntidadInformacionActividadGestionActividadEstrategica entidadInformacionActividadGestion = obtenerActividadGestionActividadEstrategicaRelacionado(entidad.getIdASE());
            if (entidadInformacionActividadGestion != null) {
                InformacionActividadGestionActividadEstrategica actividadGestionActividadEstrategica = obtenerActividadGestionActividadEstrategicaDesdeEntidadActividadGestionActividadEstrategica(entidadInformacionActividadGestion);
                mapeadorInformacionActividadGestionActividadEstrategica.actualizarPorcentajeAvance(entidadInformacionActividadGestion, actividadGestionActividadEstrategica);
            }
        }

    }
    private EntidadInformacionActividadGestion obtenerActividadGestionRelacionado(Long id) {
        return this.repositorioInformacionActividadGestionJpa.findById(id).orElse(null);
    }
    private EntidadSprint obtenerSprintRelacionado(Long id) {
        return this.repositorioSprintJpa.findById(id).orElse(null);
    }
    private EntidadInformacionActividadGestionActividadEstrategica obtenerActividadGestionActividadEstrategicaRelacionado(Long id) {
        return this.repositorioInformacionActividadGestionActividadEstrategicaJpa.findById(id).orElse(null);
    }
    private InformacionActividadGestion obtenerActividadGestionDesdeEntidadActividadGestion(EntidadInformacionActividadGestion actividadGestion) {
        return new InformacionActividadGestion(actividadGestion.getIdInformacionActividad(), actividadGestion.getFechaRegistro(),actividadGestion.getDiasRestantes(),
                actividadGestion.getDuracion(),actividadGestion.getAvance());
    }
    private Sprint obtenerSprintDesdeEntidadSprint(EntidadSprint entidadSprint) {
        return new Sprint(entidadSprint.getIdSprint(), entidadSprint.getDescripcion(), entidadSprint.getFechaInicial(), entidadSprint.getFechaFinal(),
                entidadSprint.getAvance(), entidadSprint.getEstado(), entidadSprint.getIdProyecto());
    }
    private InformacionActividadGestionActividadEstrategica obtenerActividadGestionActividadEstrategicaDesdeEntidadActividadGestionActividadEstrategica
            (EntidadInformacionActividadGestionActividadEstrategica entidadInformacionActividadGestionActividadEstrategica) {
        return new InformacionActividadGestionActividadEstrategica(entidadInformacionActividadGestionActividadEstrategica.getIdInformacionActividadActividadEstrategica(),
                entidadInformacionActividadGestionActividadEstrategica.getFechaRegistro(),entidadInformacionActividadGestionActividadEstrategica.getDiasRestantes(),
                entidadInformacionActividadGestionActividadEstrategica.getDuracion(),entidadInformacionActividadGestionActividadEstrategica.getAvance());
    }
}
