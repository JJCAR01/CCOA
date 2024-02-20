package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDiasRestantes;
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
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapeadorActividadEstrategica implements MapeadorInfraestructura<EntidadActividadEstrategica, ActividadEstrategica> {

    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioDetalleActividadEstrategicaJpa repositorioDetalleActividadEstrategicaJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final ServicioObtenerDiasRestantes servicioObtenerDiasRestantes;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;

    public MapeadorActividadEstrategica(RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa, RepositorioDetalleActividadEstrategicaJpa repositorioDetalleActividadEstrategicaJpa, RepositorioPatJpa repositorioPatJpa, RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa, ServicioObtenerDiasRestantes servicioObtenerDiasRestantes, ServicioObtenerPorcentaje servicioObtenerPorcentaje) {
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioDetalleActividadEstrategicaJpa = repositorioDetalleActividadEstrategicaJpa;
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.servicioObtenerDiasRestantes = servicioObtenerDiasRestantes;
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
            dto.setDiasRestantes(servicioObtenerDiasRestantes.calcular(entidad.getFechaFinal()));
            dto.setPorcentajeReal(infEntidad.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(servicioObtenerPorcentaje.obtenerPorcentajeEsperado(entidad.getFechaInicial(),infEntidad.orElseThrow().getDuracion()));
            dto.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(dto.getPorcentajeReal(),dto.getPorcentajeEsperado()));

            var detalleEntidad = repositorioDetalleActividadEstrategicaJpa.findById(entidad.getIdActividadEstrategica());

            dto.setUnidad(detalleEntidad.orElseThrow().getUnidad());
            dto.setMeta(detalleEntidad.orElseThrow().getMeta());
            dto.setPeriodicidadMeta(detalleEntidad.orElseThrow().getPeriodicidadMeta());
            dto.setResultadoMeta(detalleEntidad.orElseThrow().getResultadoMeta());
            dto.setPromedioMeta(detalleEntidad.orElseThrow().getPorcentajeMeta());
            dto.setEntregable(detalleEntidad.orElseThrow().getEntregable());
            dto.setPorcentajePat(servicioObtenerPorcentaje.obtenerPorcentajePat(dto.getPorcentajeCumplimiento(),dto.getPromedioMeta()));

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
        entidadInformacionActividadEstrategica.setDuracion(informacionActividadEstrategica.getDuracion());
        entidadInformacionActividadEstrategica.setDiasRestantes(informacionActividadEstrategica.getDiasRestantes());
        entidadDetalleActividadEstrategica.setMeta(detalleActividadEstrategica.getMeta());
        entidadDetalleActividadEstrategica.setPorcentajeMeta(
                servicioObtenerPorcentaje.calcularPorcentajeMeta(entidadDetalleActividadEstrategica.getMeta(), entidadDetalleActividadEstrategica.getResultadoMeta()));
        entidadInformacionActividadEstrategica.setPorcentajeReal(
                servicioObtenerPorcentaje.obtenerPorcentajePat(entidadInformacionActividadEstrategica.getPorcentajeCumplimiento(),
                        entidadDetalleActividadEstrategica.getPorcentajeMeta()));
    }

    public EntidadActividadEstrategica obtenerPatRelacionadoConActividadEstrategica(Long id){
        return this.repositorioActividadEstrategicaJpa.findById(id).orElseThrow();
    }



}
