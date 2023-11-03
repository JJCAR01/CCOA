package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDetalleProyecto implements MapeadorInfraestructura<EntidadDetalleProyecto, DetalleProyecto> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa;

    public MapeadorDetalleProyecto(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa, RepositorioProyectoJpa repositorioProyectoJpa, RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioInformacionProyectoJpa = repositorioInformacionProyectoJpa;
    }

    @Override
    public DetalleProyecto mapeadorDominio(EntidadDetalleProyecto entidad) {
        return new DetalleProyecto(entidad.getIdDetalleProyecto(), entidad.getIdActividadEstrategica(), entidad.getIdUsuario());
    }

    @Override
    public EntidadDetalleProyecto mapeadorEntidad(DetalleProyecto dominio) {
        var actividad = this.repositorioActividadEstrategicaJpa.findById(dominio.getIdActividadEstrategica()).orElseThrow().getIdActividadEstrategica();
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        return new EntidadDetalleProyecto(actividad,usuario);
    }

    public List<DtoProyectoResumen> listarDominio(List<EntidadDetalleProyecto> entidades){
        List<DtoProyectoResumen> listaDto = new ArrayList<>();
        for (EntidadDetalleProyecto entidad : entidades) {
            DtoProyectoResumen dto = new DtoProyectoResumen();
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());
            dto.setIdUsuario(entidad.getIdUsuario());

            var proyectoEntidad = repositorioProyectoJpa.findById(entidad.getIdDetalleProyecto());
            dto.setIdProyecto(proyectoEntidad.orElseThrow().getIdProyecto());
            dto.setNombre(proyectoEntidad.orElseThrow().getNombre());
            dto.setPresupuesto(proyectoEntidad.orElseThrow().getPresupuesto());
            dto.setModalidad(proyectoEntidad.orElseThrow().getModalidad().toString());
            dto.setValorEjecutado(proyectoEntidad.orElseThrow().getValorEjecutado());
            var informacionEntidad = repositorioInformacionProyectoJpa.findById(entidad.getIdDetalleProyecto());
            dto.setFechaInicial(informacionEntidad.orElseThrow().getFechaInicial());
            dto.setFechaFinal(informacionEntidad.orElseThrow().getFechaFinal());
            dto.setDuracion(informacionEntidad.orElseThrow().getDuracion());
            dto.setAvance(informacionEntidad.orElseThrow().getAvance());
            dto.setPlaneacionSprint(informacionEntidad.orElseThrow().getPlaneacionSprint().toString());
            dto.setTotalSprint(informacionEntidad.orElseThrow().getTotalSprint());

            listaDto.add(dto);
        }
        return listaDto;
    }
}
