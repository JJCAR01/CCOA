package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDuracion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioDetalleActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MapeadorActividadEstrategica implements MapeadorInfraestructura<EntidadActividadEstrategica, ActividadEstrategica> {

    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioDetalleActividadEstrategicaJpa repositorioDetalleActividadEstrategicaJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final ServicioObtenerDuracion servicioObtenerDuracion;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;

    public MapeadorActividadEstrategica(RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa,
                                        RepositorioDetalleActividadEstrategicaJpa repositorioDetalleActividadEstrategicaJpa, RepositorioPatJpa repositorioPatJpa,
                                        RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa,
                                        ServicioObtenerDuracion servicioObtenerDuracion,
                                        ServicioObtenerPorcentaje servicioObtenerPorcentaje) {
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioDetalleActividadEstrategicaJpa = repositorioDetalleActividadEstrategicaJpa;
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.servicioObtenerDuracion = servicioObtenerDuracion;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
    }
    @Override
    public ActividadEstrategica mapeadorDominio(EntidadActividadEstrategica entidad) {
        return new ActividadEstrategica(entidad.getIdActividadEstrategica(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getFechaRegistro(), entidad.getIdPat(),entidad.getIdUsuario());
    }
    @Override
    public EntidadActividadEstrategica mapeadorEntidad(ActividadEstrategica dominio) {
        var pat = this.repositorioPatJpa.findById(dominio.getIdPat()).orElseThrow().getIdPat();
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        return new EntidadActividadEstrategica(dominio.getNombre(),dominio.getFechaInicial(),dominio.getFechaFinal(),dominio.getFechaRegistro()
                ,pat,usuario);
    }
    public DtoActividadEstrategicaResumen listarDominioPorId(EntidadActividadEstrategica entidad,
                                                             EntidadInformacionActividadEstrategica entidadInformacionActividadEstrategica,
                                                             EntidadDetalleActividadEstrategica entidadDetalleActividadEstrategica) {
        return new DtoActividadEstrategicaResumen( entidad.getIdActividadEstrategica(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getFechaRegistro(),entidadInformacionActividadEstrategica.getDuracion(), entidadInformacionActividadEstrategica.getDiasRestantes(),
                entidadInformacionActividadEstrategica.getPorcentajeReal(),entidadInformacionActividadEstrategica.getPorcentajeEsperado(),
                entidadInformacionActividadEstrategica.getPorcentajeCumplimiento(), entidadInformacionActividadEstrategica.getPorcentajePat(),
                entidadDetalleActividadEstrategica.getUnidad(),entidadDetalleActividadEstrategica.getMeta(),entidadDetalleActividadEstrategica.getPeriodicidadMeta(),
                entidadDetalleActividadEstrategica.getResultadoMeta(), entidadDetalleActividadEstrategica.getPorcentajeMeta(),
                entidadDetalleActividadEstrategica.getEntregable(),entidad.getIdUsuario(),entidad.getIdPat());
    }

    public List<DtoActividadEstrategicaResumen> listarDominio(List<EntidadActividadEstrategica> entidades){
        List<DtoActividadEstrategicaResumen> listaDto = new ArrayList<>();
        for (EntidadActividadEstrategica entidad : entidades) {
            DtoActividadEstrategicaResumen dto = new DtoActividadEstrategicaResumen();
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setFechaRegistro(entidad.getFechaRegistro());
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setIdPat(entidad.getIdPat());

            var infEntidad = repositorioInformacionActividadEstrategicaJpa.findById(entidad.getIdActividadEstrategica());

            dto.setDuracion(infEntidad.orElseThrow().getDuracion());
            dto.setDiasRestantes(infEntidad.orElseThrow().getDiasRestantes());
            dto.setPorcentajeReal(infEntidad.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(infEntidad.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(dto.getPorcentajeReal(),dto.getPorcentajeEsperado()));

            var detalleEntidad = repositorioDetalleActividadEstrategicaJpa.findById(entidad.getIdActividadEstrategica());

            dto.setUnidad(detalleEntidad.orElseThrow().getUnidad());
            dto.setMeta(detalleEntidad.orElseThrow().getMeta());
            dto.setPeriodicidadMeta(detalleEntidad.orElseThrow().getPeriodicidadMeta());
            dto.setResultadoMeta(detalleEntidad.orElseThrow().getResultadoMeta());
            dto.setPromedioMeta(detalleEntidad.orElseThrow().getPorcentajeMeta());
            dto.setEntregable(detalleEntidad.orElseThrow().getEntregable());
            dto.setPorcentajePat(servicioObtenerPorcentaje.obtenerPorcentajePat(
                    infEntidad.orElseThrow().getPorcentajeCumplimiento(),detalleEntidad.orElseThrow().getPorcentajeMeta()));

            listaDto.add(dto);
        }
        return listaDto;
    }
    public List<DtoActividadEstrategica> crearActividadDuplicada(List<EntidadActividadEstrategica> entidades){
        List<DtoActividadEstrategica> listaDto = new ArrayList<>();
        for (EntidadActividadEstrategica entidad : entidades) {
            DtoActividadEstrategica dto = new DtoActividadEstrategica();
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setIdUsuario(entidad.getIdUsuario());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public List<DtoIdsActividadEstrategica> listarPorIds(List<EntidadActividadEstrategica> entidades){
        List<DtoIdsActividadEstrategica> listaDto = new ArrayList<>();
        for (EntidadActividadEstrategica entidad : entidades) {
            DtoIdsActividadEstrategica dto = new DtoIdsActividadEstrategica();
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());
            dto.setIdPat(entidad.getIdPat());

            var infEntidad = repositorioInformacionActividadEstrategicaJpa.findById(entidad.getIdActividadEstrategica());

            dto.setIdInformacionActividadEstrategica(infEntidad.orElseThrow().getIdInformacionActividadEstrategica());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void  actualizarEntidad(EntidadActividadEstrategica entidad, ActividadEstrategica actividadEstrategica,
                                  EntidadInformacionActividadEstrategica entidadInformacionActividadEstrategica,
                                  InformacionActividadEstrategica informacionActividadEstrategica,
                                  EntidadDetalleActividadEstrategica entidadDetalleActividadEstrategica,
                                  DetalleActividadEstrategica detalleActividadEstrategica) {
        entidad.setNombre(actividadEstrategica.getNombre());
        entidad.setFechaInicial(actividadEstrategica.getFechaInicial());
        entidad.setFechaFinal(actividadEstrategica.getFechaFinal());
        entidad.setIdUsuario(actividadEstrategica.getIdUsuario());
        var duracion = obtenerDuracion(entidad.getFechaInicial(),entidad.getFechaFinal());
        entidadInformacionActividadEstrategica.setDuracion(duracion);
        entidadInformacionActividadEstrategica.setDiasRestantes(informacionActividadEstrategica.getDiasRestantes());
        entidadInformacionActividadEstrategica.setPorcentajeEsperado(obtenerPorcentajeEsperado(entidad.getFechaInicial(),duracion));
        entidadDetalleActividadEstrategica.setMeta(detalleActividadEstrategica.getMeta());
        entidadDetalleActividadEstrategica.setUnidad(detalleActividadEstrategica.getUnidad());
        entidadDetalleActividadEstrategica.setPeriodicidadMeta(detalleActividadEstrategica.getPeriodicidadMeta());
        entidadDetalleActividadEstrategica.setEntregable(detalleActividadEstrategica.getEntregable());
        entidadDetalleActividadEstrategica.setPorcentajeMeta(
                servicioObtenerPorcentaje.calcularPorcentajeMeta(entidadDetalleActividadEstrategica.getMeta(), entidadDetalleActividadEstrategica.getResultadoMeta()));
        entidadInformacionActividadEstrategica.setPorcentajeReal(
                servicioObtenerPorcentaje.obtenerPorcentajePat(entidadInformacionActividadEstrategica.getPorcentajeCumplimiento(),
                        entidadDetalleActividadEstrategica.getPorcentajeMeta()));
    }

    public EntidadActividadEstrategica obtenerEntidadRelacionadoConActividadEstrategica(Long id){
        return this.repositorioActividadEstrategicaJpa.findById(id).orElseThrow();
    }


    public Integer obtenerDuracion(LocalDate fechaInicial, LocalDate fechaFinal){
        return servicioObtenerDuracion.calcular(fechaInicial,fechaFinal);
    }
    public double obtenerPorcentajeEsperado(LocalDate fechaInicial, long duracion){
        return Math.min(servicioObtenerPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion), Mensaje.PORCENTAJE);
    }
}
