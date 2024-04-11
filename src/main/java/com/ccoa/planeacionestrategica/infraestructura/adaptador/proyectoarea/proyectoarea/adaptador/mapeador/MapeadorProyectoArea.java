package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoProyectoArea;
import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoAreaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.InformacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.ProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDuracion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadDetalleProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadInformacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioDetalleProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioInformacionProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorProyectoArea implements MapeadorInfraestructura<EntidadProyectoArea, ProyectoArea> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioProyectoAreaJpa repositorioProyectoAreaJpa;
    private final RepositorioDetalleProyectoAreaJpa repositorioDetalleProyectoAreaJpa;
    private final RepositorioInformacionProyectoAreaJpa repositorioInformacionProyectoAreaJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final ServicioObtenerDuracion servicioObtenerDuracion;

    public MapeadorProyectoArea(RepositorioUsuarioJpa repositorioUsuarioJpa,

                                RepositorioProyectoAreaJpa repositorioProyectoAreaJpa, RepositorioDetalleProyectoAreaJpa repositorioDetalleProyectoAreaJpa, RepositorioInformacionProyectoAreaJpa repositorioInformacionProyectoAreaJpa, RepositorioPatJpa repositorioPatJpa, ServicioObtenerPorcentaje servicioObtenerPorcentaje, ServicioObtenerDuracion servicioObtenerDuracion) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioProyectoAreaJpa = repositorioProyectoAreaJpa;
        this.repositorioDetalleProyectoAreaJpa = repositorioDetalleProyectoAreaJpa;
        this.repositorioInformacionProyectoAreaJpa = repositorioInformacionProyectoAreaJpa;
        this.repositorioPatJpa = repositorioPatJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.servicioObtenerDuracion = servicioObtenerDuracion;
    }

    @Override
    public ProyectoArea mapeadorDominio(EntidadProyectoArea entidad) {
        return new ProyectoArea(entidad.getIdProyectoArea(), entidad.getNombre(), entidad.getPresupuesto(),entidad.getModalidad(),
                entidad.getValorEjecutado(), entidad.getIdPat(), entidad.getIdUsuario());
    }
    @Override
    public EntidadProyectoArea mapeadorEntidad(ProyectoArea dominio) {
        var pat = this.repositorioPatJpa.findById(dominio.getIdPat()).orElseThrow().getIdPat();
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        return new EntidadProyectoArea(dominio.getNombre(),dominio.getPresupuesto(),dominio.getModalidad(),dominio.getValorEjecutado(),
                pat,usuario);
    }

    public List<DtoProyectoAreaResumen> listarDominio(List<EntidadProyectoArea> entidades){
        List<DtoProyectoAreaResumen> listaDto = new ArrayList<>();
        for (EntidadProyectoArea entidad : entidades) {
            DtoProyectoAreaResumen dto = new DtoProyectoAreaResumen();
            dto.setIdProyectoArea(entidad.getIdProyectoArea());
            dto.setNombre(entidad.getNombre());
            dto.setPresupuesto(entidad.getPresupuesto());
            dto.setModalidad(entidad.getModalidad());
            dto.setValorEjecutado(entidad.getValorEjecutado());
            dto.setIdPat(entidad.getIdPat());
            dto.setIdUsuario(entidad.getIdUsuario());

            var detalleEntidad = repositorioDetalleProyectoAreaJpa.findById(entidad.getIdProyectoArea());

            dto.setDuracion(detalleEntidad.orElseThrow().getDuracion());
            dto.setPorcentajeReal(detalleEntidad.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(detalleEntidad.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(dto.getPorcentajeReal(),dto.getPorcentajeEsperado()));

            var informacionEntidad = repositorioInformacionProyectoAreaJpa.findById(entidad.getIdProyectoArea());
            dto.setFechaInicial(informacionEntidad.orElseThrow().getFechaInicial());
            dto.setFechaFinal(informacionEntidad.orElseThrow().getFechaFinal());
            dto.setFechaRegistro(informacionEntidad.orElseThrow().getFechaRegistro());
            dto.setPlaneacionSprint(informacionEntidad.orElseThrow().getPlaneacionSprint());
            dto.setTotalSprint(informacionEntidad.orElseThrow().getTotalSprint());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public List<DtoProyectoArea> obtenerProyectosAreaParaDuplicar(List<EntidadProyectoArea> entidades){
        List<DtoProyectoArea> listaDto = new ArrayList<>();
        for (EntidadProyectoArea entidad : entidades) {
            DtoProyectoArea dto = new DtoProyectoArea();
            dto.setIdProyectoArea(entidad.getIdProyectoArea());
            dto.setNombre(entidad.getNombre());
            dto.setModalidad(entidad.getModalidad());
            dto.setIdUsuario(entidad.getIdUsuario());

            var informacionEntidad = repositorioInformacionProyectoAreaJpa.findById(entidad.getIdProyectoArea());
            dto.setFechaInicial(informacionEntidad.orElseThrow().getFechaInicial());
            dto.setFechaFinal(informacionEntidad.orElseThrow().getFechaFinal());
            dto.setPlaneacionSprint(informacionEntidad.orElseThrow().getPlaneacionSprint());

            listaDto.add(dto);
        }
        return listaDto;
    }


    public List<DtoIdsProyectoArea> listarIds(List<EntidadProyectoArea> entidades){
        List<DtoIdsProyectoArea> listaDto = new ArrayList<>();
        for (EntidadProyectoArea entidad : entidades) {
            DtoIdsProyectoArea dto = new DtoIdsProyectoArea();
            dto.setIdProyectoArea(entidad.getIdProyectoArea());
            dto.setIdPat(entidad.getIdPat());

            var detalleEntidad = repositorioDetalleProyectoAreaJpa.findById(entidad.getIdProyectoArea());
            dto.setIdDetalleProyectoArea(detalleEntidad.orElseThrow().getIdDetalleProyectoArea());

            var informacionEntidad = repositorioInformacionProyectoAreaJpa.findById(entidad.getIdProyectoArea());
            dto.setIdInformacionProyectoArea(informacionEntidad.orElseThrow().getIdInformacionProyectoArea());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadProyectoArea entidad, ProyectoArea proyectoArea,
                                  EntidadInformacionProyectoArea entidadInformacionProyectoArea,
                                  InformacionProyectoArea informacionProyectoArea,EntidadDetalleProyectoArea entidadDetalleProyectoArea) {
        entidad.setNombre(proyectoArea.getNombre());
        entidad.setPresupuesto(proyectoArea.getPresupuesto());
        entidad.setModalidad(proyectoArea.getModalidad());
        entidad.setIdUsuario(proyectoArea.getIdUsuario());
        entidadInformacionProyectoArea.setFechaInicial(informacionProyectoArea.getFechaInicial());
        entidadInformacionProyectoArea.setFechaFinal(informacionProyectoArea.getFechaFinal());
        var duracion = obtenerDuracion(informacionProyectoArea.getFechaInicial(),informacionProyectoArea.getFechaFinal());
        entidadDetalleProyectoArea.setDuracion(duracion);
        entidadDetalleProyectoArea.setPorcentajeEsperado(obtenerPorcentajeEsperado(informacionProyectoArea.getFechaInicial(),duracion));
        entidadInformacionProyectoArea.setTotalSprint(informacionProyectoArea.getTotalSprint());
        entidadInformacionProyectoArea.setPlaneacionSprint(informacionProyectoArea.getPlaneacionSprint());

    }
    public void actualizarValorEjecutado(EntidadProyectoArea entidad, ProyectoArea proyectoArea) {
        entidad.setValorEjecutado(proyectoArea.getValorEjecutado());
    }
    public DtoProyectoAreaResumen mapeadorDominioProyectoArea(EntidadProyectoArea entidad, EntidadDetalleProyectoArea entidadDetalleProyectoArea,
                                                              EntidadInformacionProyectoArea entidadInformacionProyectoArea) {
        return new DtoProyectoAreaResumen(entidad.getIdProyectoArea(), entidad.getNombre(), entidad.getPresupuesto(),entidad.getModalidad(),
                entidad.getValorEjecutado(),entidadInformacionProyectoArea.getTotalSprint(),entidadInformacionProyectoArea.getPlaneacionSprint(),
                entidadInformacionProyectoArea.getFechaInicial(),entidadInformacionProyectoArea.getFechaFinal(),entidadInformacionProyectoArea.getFechaRegistro()
                ,entidadDetalleProyectoArea.getDuracion(),entidadDetalleProyectoArea.getPorcentajeReal(),entidadDetalleProyectoArea.getPorcentajeEsperado(),
                entidadDetalleProyectoArea.getPorcentajeCumplimiento(),entidad.getIdPat(),entidad.getIdUsuario());
    }

    public EntidadProyectoArea obtenerProyectoAreaRelacionadoConElProyecto(Long id){
        return this.repositorioProyectoAreaJpa.findById(id).orElseThrow();
    }

    public Integer obtenerDuracion(LocalDate fechaInicial, LocalDate fechaFinal){
        return servicioObtenerDuracion.calcular(fechaInicial,fechaFinal);
    }
    public double obtenerPorcentajeEsperado(LocalDate fechaInicial, long duracion){
        return Math.min(servicioObtenerPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion), Mensaje.PORCENTAJE);
    }

}
