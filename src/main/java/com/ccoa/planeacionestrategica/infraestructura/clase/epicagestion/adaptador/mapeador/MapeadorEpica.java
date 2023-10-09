package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoEpicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadEpica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.jpa.RepositorioInformacionEpicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapeadorEpica implements MapeadorInfraestructura<EntidadEpica, Epica> {

    @Autowired
    private RepositorioInformacionEpicaJpa repositorioInformacionEpicaJpa;
    @Override
    public Epica mapeadorDominio(EntidadEpica entidad) {
        return new Epica(entidad.getIdEpica(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getFechaRegistro(), entidad.getIdInformacionEpica());
    }
    @Override
    public EntidadEpica mapeadorEntidad(Epica dominio) {
        return new EntidadEpica(dominio.getNombre(),dominio.getFechaInicial(),dominio.getFechaFinal(),dominio.getFechaRegistro(),
                dominio.getIdInformacionEpica());
    }
    public List<DtoEpicaResumen> listarDominio(List<EntidadEpica> entidades){
        List<DtoEpicaResumen> listaDto = new ArrayList<>();
        for (EntidadEpica entidad : entidades) {
            DtoEpicaResumen dto = new DtoEpicaResumen();
            dto.setIdEpica(entidad.getIdEpica());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());

            var infEntidad = repositorioInformacionEpicaJpa.findById(entidad.getIdInformacionEpica());

            dto.setDuracion(infEntidad.orElseThrow().getDuracion());
            dto.setDiasRestantes(infEntidad.orElseThrow().getDiasRestantes());
            dto.setEstado(infEntidad.orElseThrow().getEstado());
            dto.setAvance(infEntidad.orElseThrow().getAvance());
            dto.setIdUsuario(infEntidad.orElseThrow().getIdUsuario());
            dto.setIdPat(infEntidad.orElseThrow().getIdPat());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadEpica entidad, Epica epica) {
        entidad.setNombre(epica.getNombre());
    }
}
