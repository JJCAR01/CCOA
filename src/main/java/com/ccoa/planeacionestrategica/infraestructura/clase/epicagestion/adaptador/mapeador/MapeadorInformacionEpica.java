package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoEpicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadInformacionEpica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.jpa.RepositorioEpicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapeadorInformacionEpica implements MapeadorInfraestructura<EntidadInformacionEpica, InformacionEpica> {

    @Autowired
    private RepositorioUsuarioJpa repositorioUsuarioJpa;
    @Autowired
    private RepositorioPatJpa repositorioPatJpa;
    @Autowired
    private RepositorioEpicaJpa repositorioEpicaJpa;
    @Override
    public InformacionEpica mapeadorDominio(EntidadInformacionEpica entidad) {
        return new InformacionEpica(entidad.getIdInformacionEpica(), entidad.getDuracion(), entidad.getDiasRestantes(),entidad.getEstado(),
                entidad.getAvance(), entidad.getIdUsuario(), entidad.getIdPat());
    }

    @Override
    public EntidadInformacionEpica mapeadorEntidad(InformacionEpica dominio) {
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        var pat = this.repositorioPatJpa.findById(dominio.getIdPat()).orElseThrow().getIdPat();
        return new EntidadInformacionEpica(dominio.getDuracion(),dominio.getDiasRestantes(),dominio.getEstado(), dominio.getAvance(),
                usuario,pat);
    }
    public List<DtoEpicaResumen> listaDominioPorPat(List<EntidadInformacionEpica> entidades){
        List<DtoEpicaResumen> listaDto = new ArrayList<>();
        for (EntidadInformacionEpica entidad : entidades) {
            DtoEpicaResumen dto = new DtoEpicaResumen();
            dto.setDuracion(entidad.getDuracion());
            dto.setDiasRestantes(entidad.getDiasRestantes());
            dto.setEstado(entidad.getEstado());
            dto.setAvance(entidad.getAvance());
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setIdPat(entidad.getIdPat());

            var infEntidad = repositorioEpicaJpa.findByIdInformacionEpica(entidad.getIdInformacionEpica());

            dto.setIdEpica(infEntidad.getIdEpica());
            dto.setNombre(infEntidad.getNombre());
            dto.setFechaInicial(infEntidad.getFechaInicial());
            dto.setFechaFinal(infEntidad.getFechaFinal());

            listaDto.add(dto);
        }
        return listaDto;
    }

}
