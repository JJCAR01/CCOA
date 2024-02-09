package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioDetalleProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorProyecto implements MapeadorInfraestructura<EntidadProyecto, Proyecto> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa;
    private final RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;

    public MapeadorProyecto(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioProyectoJpa repositorioProyectoJpa, RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa, RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa, RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa, ServicioObtenerPorcentaje servicioObtenerPorcentaje) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioDetalleProyectoJpa = repositorioDetalleProyectoJpa;
        this.repositorioInformacionProyectoJpa = repositorioInformacionProyectoJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
    }

    @Override
    public Proyecto mapeadorDominio(EntidadProyecto entidad) {
        return new Proyecto(entidad.getIdProyecto(), entidad.getNombre(), entidad.getPresupuesto(),entidad.getModalidad(),
                entidad.getValorEjecutado(), entidad.getIdActividadEstrategica(), entidad.getIdUsuario());
    }
    @Override
    public EntidadProyecto mapeadorEntidad(Proyecto dominio) {
        var actividad = this.repositorioActividadEstrategicaJpa.findById(dominio.getIdActividadEstrategica()).orElseThrow().getIdActividadEstrategica();
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        return new EntidadProyecto(dominio.getNombre(),dominio.getPresupuesto(),dominio.getModalidad(),dominio.getValorEjecutado(),
                actividad,usuario);
    }

    public List<DtoProyectoResumen> listarDominio(List<EntidadProyecto> entidades){
        List<DtoProyectoResumen> listaDto = new ArrayList<>();
        for (EntidadProyecto entidad : entidades) {
            DtoProyectoResumen dto = new DtoProyectoResumen();
            dto.setIdProyecto(entidad.getIdProyecto());
            dto.setNombre(entidad.getNombre());
            dto.setPresupuesto(entidad.getPresupuesto());
            dto.setModalidad(entidad.getModalidad());
            dto.setValorEjecutado(entidad.getValorEjecutado());
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());
            dto.setIdUsuario(entidad.getIdUsuario());

            var detalleEntidad = repositorioDetalleProyectoJpa.findById(entidad.getIdProyecto());

            dto.setDuracion(detalleEntidad.orElseThrow().getDuracion());
            dto.setPorcentajeReal(detalleEntidad.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeCumplimiento(detalleEntidad.orElseThrow().getPorcentajeCumplimiento());

            var informacionEntidad = repositorioInformacionProyectoJpa.findById(entidad.getIdProyecto());
            dto.setFechaInicial(informacionEntidad.orElseThrow().getFechaInicial());
            dto.setFechaFinal(informacionEntidad.orElseThrow().getFechaFinal());
            dto.setFechaRegistro(informacionEntidad.orElseThrow().getFechaRegistro());
            dto.setPorcentajeEsperado(servicioObtenerPorcentaje.obtenerPorcentajeEsperado(informacionEntidad.orElseThrow().getFechaInicial(),
                    detalleEntidad.orElseThrow().getDuracion()));
            dto.setPlaneacionSprint(informacionEntidad.orElseThrow().getPlaneacionSprint());
            dto.setTotalSprint(informacionEntidad.orElseThrow().getTotalSprint());

            listaDto.add(dto);
        }
        return listaDto;
    }


    public List<DtoIdsProyecto> listarIds(List<EntidadProyecto> entidades){
        List<DtoIdsProyecto> listaDto = new ArrayList<>();
        for (EntidadProyecto entidad : entidades) {
            DtoIdsProyecto dto = new DtoIdsProyecto();
            dto.setIdProyecto(entidad.getIdProyecto());
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());

            var detalleEntidad = repositorioDetalleProyectoJpa.findById(entidad.getIdProyecto());
            dto.setIdDetalleProyecto(detalleEntidad.orElseThrow().getIdDetalleProyecto());

            var informacionEntidad = repositorioInformacionProyectoJpa.findById(entidad.getIdProyecto());
            dto.setIdInformacionProyecto(informacionEntidad.orElseThrow().getIdInformacionProyecto());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadProyecto entidad, Proyecto proyecto,
                                  EntidadInformacionProyecto entidadInformacionProyecto,
                                  InformacionProyecto informacionProyecto) {
        entidad.setNombre(proyecto.getNombre());
        entidad.setPresupuesto(proyecto.getPresupuesto());
        entidad.setModalidad(proyecto.getModalidad());
        entidadInformacionProyecto.setPlaneacionSprint(informacionProyecto.getPlaneacionSprint());
        entidadInformacionProyecto.setFechaInicial(informacionProyecto.getFechaInicial());
        entidadInformacionProyecto.setFechaFinal(informacionProyecto.getFechaFinal());
    }
    public DtoProyectoResumen mapeadorDominioProyecto(EntidadProyecto entidad, EntidadDetalleProyecto entidadDetalleProyecto,
                                                      EntidadInformacionProyecto entidadInformacionProyecto) {
        return new DtoProyectoResumen(entidad.getIdProyecto(), entidad.getNombre(), entidad.getPresupuesto(),entidad.getModalidad(),
                entidad.getValorEjecutado(),entidadInformacionProyecto.getTotalSprint(),entidadInformacionProyecto.getPlaneacionSprint(),
                entidadInformacionProyecto.getFechaInicial(),entidadInformacionProyecto.getFechaFinal(),entidadInformacionProyecto.getFechaRegistro()
                ,entidadDetalleProyecto.getDuracion(),entidadDetalleProyecto.getPorcentajeReal(),entidadDetalleProyecto.getPorcentajeEsperado(),
                entidadDetalleProyecto.getPorcentajeCumplimiento(),entidad.getIdActividadEstrategica(),entidad.getIdUsuario());
    }

    public EntidadProyecto obtenerActividadEstrategicaRelacionadoConElProyecto(Long id){
        return this.repositorioProyectoJpa.findById(id).orElseThrow();
    }

}
