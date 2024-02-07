package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapeadorActividadEstrategica implements MapeadorInfraestructura<EntidadActividadEstrategica, ActividadEstrategica> {

    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final ServicioObtenerDiasRestantes servicioObtenerDiasRestantes;

    public MapeadorActividadEstrategica(RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa, RepositorioPatJpa repositorioPatJpa, RepositorioUsuarioJpa repositorioUsuarioJpa, ServicioObtenerDiasRestantes servicioObtenerDiasRestantes) {
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.servicioObtenerDiasRestantes = servicioObtenerDiasRestantes;
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
                                                             EntidadInformacionActividadEstrategica entidadInformacionActividadEstrategica) {
        return new DtoActividadEstrategicaResumen(
                entidad.getIdActividadEstrategica(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),entidad.getFechaRegistro(),
                entidadInformacionActividadEstrategica.getDuracion(), entidadInformacionActividadEstrategica.getDiasRestantes(),
                entidadInformacionActividadEstrategica.getPorcentajeReal(),entidadInformacionActividadEstrategica.getPorcentajeEsperado(),
                entidadInformacionActividadEstrategica.getPorcentajeCumplimiento(),entidad.getIdPat(),entidad.getIdUsuario());
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
            dto.setPorcentajeEsperado(infEntidad.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(infEntidad.orElseThrow().getPorcentajeCumplimiento());

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

    public void actualizarEntidad(EntidadActividadEstrategica entidad, ActividadEstrategica actividadEstrategica,
                                  EntidadInformacionActividadEstrategica entidadInformacionActividadEstrategica,
                                  InformacionActividadEstrategica informacionActividadEstrategica) {
        entidad.setNombre(actividadEstrategica.getNombre());
        entidad.setFechaInicial(actividadEstrategica.getFechaInicial());
        entidad.setFechaFinal(actividadEstrategica.getFechaFinal());
        entidadInformacionActividadEstrategica.setDuracion(informacionActividadEstrategica.getDuracion());
        entidadInformacionActividadEstrategica.setDiasRestantes(informacionActividadEstrategica.getDiasRestantes());
    }



}
