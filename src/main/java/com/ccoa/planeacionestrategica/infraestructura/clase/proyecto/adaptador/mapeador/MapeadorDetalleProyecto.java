package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.mapeador.MapeadorInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDetalleProyecto implements MapeadorInfraestructura<EntidadDetalleProyecto, DetalleProyecto> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa;
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica;

    public MapeadorDetalleProyecto(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa,
                                   RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa,
                                   RepositorioProyectoJpa repositorioProyectoJpa, RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa,
                                   RepositorioSprintJpa repositorioSprintJpa, MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioInformacionProyectoJpa = repositorioInformacionProyectoJpa;
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.mapeadorInformacionActividadEstrategica = mapeadorInformacionActividadEstrategica;
    }
    @Override
    public DetalleProyecto mapeadorDominio(EntidadDetalleProyecto entidad) {
        return new DetalleProyecto(entidad.getIdDetalleProyecto(), entidad.getAvance(), entidad.getIdActividadEstrategica(), entidad.getIdUsuario());
    }
    @Override
    public EntidadDetalleProyecto mapeadorEntidad(DetalleProyecto dominio) {
        var actividad = this.repositorioActividadEstrategicaJpa.findById(dominio.getIdActividadEstrategica()).orElseThrow().getIdActividadEstrategica();
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        return new EntidadDetalleProyecto(dominio.getAvance(),actividad,usuario);
    }
    public List<DtoProyectoResumen> listarDominio(List<EntidadDetalleProyecto> entidades){
        List<DtoProyectoResumen> listaDto = new ArrayList<>();
        for (EntidadDetalleProyecto entidad : entidades) {
            DtoProyectoResumen dto = new DtoProyectoResumen();
            dto.setAvance(entidad.getAvance());
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());
            dto.setIdUsuario(entidad.getIdUsuario());

            var proyectoEntidad = repositorioProyectoJpa.findById(entidad.getIdDetalleProyecto());
            dto.setIdProyecto(proyectoEntidad.orElseThrow().getIdProyecto());
            dto.setNombre(proyectoEntidad.orElseThrow().getNombre());
            dto.setPresupuesto(proyectoEntidad.orElseThrow().getPresupuesto());
            dto.setModalidad(proyectoEntidad.orElseThrow().getModalidad());
            dto.setValorEjecutado(proyectoEntidad.orElseThrow().getValorEjecutado());

            var informacionEntidad = repositorioInformacionProyectoJpa.findById(entidad.getIdDetalleProyecto());
            dto.setFechaInicial(informacionEntidad.orElseThrow().getFechaInicial());
            dto.setFechaFinal(informacionEntidad.orElseThrow().getFechaFinal());
            dto.setDuracion(informacionEntidad.orElseThrow().getDuracion());
            dto.setPlaneacionSprint(informacionEntidad.orElseThrow().getPlaneacionSprint());
            dto.setTotalSprint(informacionEntidad.orElseThrow().getTotalSprint());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarPorcentajeAvance(EntidadDetalleProyecto entidad) {
        List<EntidadSprint> sprints = this.repositorioSprintJpa.findByIdProyecto(entidad.getIdDetalleProyecto());
        long totalSprints = sprints.size();
        double sumaSprint = sprints.stream().mapToDouble(EntidadSprint::getAvance).sum();

        if (totalSprints > 0) {
            int nuevoAvance = (int) (sumaSprint / totalSprints);
            entidad.setAvance((double) nuevoAvance);
            mapeadorInformacionActividadEstrategica.actualizarPorcentajeAvance(obtenerProyectoRelacionado(entidad.getIdActividadEstrategica()));
        }
    }

    public EntidadInformacionActividadEstrategica obtenerProyectoRelacionado(Long id){
        return this.repositorioInformacionActividadEstrategicaJpa.findById(id).orElseThrow();
    }


}
