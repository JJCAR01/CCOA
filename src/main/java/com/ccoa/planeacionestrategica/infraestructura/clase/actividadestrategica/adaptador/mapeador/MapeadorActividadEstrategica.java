package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapeadorActividadEstrategica implements MapeadorInfraestructura<EntidadActividadEstrategica, ActividadEstrategica> {

    @Autowired
    private RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    @Override
    public ActividadEstrategica mapeadorDominio(EntidadActividadEstrategica entidad) {
        return new ActividadEstrategica(entidad.getIdActividadEstrategica(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getFechaRegistro());
    }
    @Override
    public EntidadActividadEstrategica mapeadorEntidad(ActividadEstrategica dominio) {
        return new EntidadActividadEstrategica(dominio.getNombre(),dominio.getFechaInicial(),dominio.getFechaFinal(),dominio.getFechaRegistro()
                );
    }
    public List<DtoActividadEstrategicaResumen> listarDominio(List<EntidadActividadEstrategica> entidades){
        List<DtoActividadEstrategicaResumen> listaDto = new ArrayList<>();
        for (EntidadActividadEstrategica entidad : entidades) {
            DtoActividadEstrategicaResumen dto = new DtoActividadEstrategicaResumen();
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());

            var infEntidad = repositorioInformacionActividadEstrategicaJpa.findById(entidad.getIdActividadEstrategica());

            dto.setDuracion(infEntidad.orElseThrow().getDuracion());
            dto.setDiasRestantes(infEntidad.orElseThrow().getDiasRestantes());
            dto.setEstado(infEntidad.orElseThrow().getEstado());
            dto.setAvance(infEntidad.orElseThrow().getAvance());
            dto.setIdPat(infEntidad.orElseThrow().getIdPat());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadActividadEstrategica entidad, ActividadEstrategica actividadEstrategica) {
        entidad.setNombre(actividadEstrategica.getNombre());
    }
}
