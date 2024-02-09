package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador;
import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.aplicacion.dto.proceso.DtoProceso;
import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorPat implements MapeadorInfraestructura<EntidadPat, Pat> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;
    public MapeadorPat(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioInformacionPatJpa repositorioInformacionPatJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
    }

    @Override
    public Pat mapeadorDominio(EntidadPat entidad) {
        return new Pat(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro(),
                entidad.getIdUsuario());
    }
    @Override
    public EntidadPat mapeadorEntidad(Pat dominio) {
        var idUsuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();

        return new EntidadPat(dominio.getNombre(), dominio.getFechaAnual(),dominio.getFechaRegistro(),idUsuario);
    }
    public DtoPatResumen patDominio(EntidadPat entidad, EntidadInformacionPat entidadInformacionPat) {
        DtoProceso dtoProceso = new DtoProceso();
        dtoProceso.setNombre(entidadInformacionPat.getProceso().getNombre());

        DtoDireccion dtoDireccion = new DtoDireccion();
        dtoDireccion.setNombre(entidadInformacionPat.getDireccion().getNombre());

        return new DtoPatResumen(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro()
                ,entidadInformacionPat.getPorcentajeReal(), entidadInformacionPat.getPorcentajeEsperado(),
                entidadInformacionPat.getPorcentajeCumplimiento(),dtoProceso ,
                dtoDireccion,entidad.getIdUsuario());
    }
    public List<DtoPatResumen> listarDominio(List<EntidadPat> entidades){
        List<DtoPatResumen> listaDto = new ArrayList<>();
        for (EntidadPat entidad : entidades) {
            DtoPatResumen dto = new DtoPatResumen();
            dto.setIdPat(entidad.getIdPat());
            dto.setNombre(entidad.getNombre());
            dto.setFechaAnual(entidad.getFechaAnual());
            dto.setFechaRegistro(entidad.getFechaRegistro());
            dto.setIdUsuario(entidad.getIdUsuario());

            var infEntidad = repositorioInformacionPatJpa.findById(entidad.getIdPat());

            dto.setPorcentajeReal(infEntidad.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(infEntidad.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(infEntidad.orElseThrow().getPorcentajeCumplimiento());

            DtoProceso dtoProceso = new DtoProceso();
            dtoProceso.setNombre(infEntidad.orElseThrow().getProceso().getNombre());
            dto.setProceso(dtoProceso);

            DtoDireccion dtoDireccion = new DtoDireccion();
            dtoDireccion.setNombre(infEntidad.orElseThrow().getDireccion().getNombre());
            dto.setDireccion(dtoDireccion);

            listaDto.add(dto);
        }
        return listaDto;
    }



    public void actualizarEntidad(EntidadPat entidad, Pat pat) {
        entidad.setNombre(pat.getNombre());
        entidad.setFechaAnual(pat.getFechaAnual());
        entidad.setIdUsuario(pat.getIdUsuario());
    }
}
