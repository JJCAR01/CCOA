package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapeadorActividadEstrategica implements MapeadorInfraestructura<EntidadActividadEstrategica, ActividadEstrategica> {

    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;

    public MapeadorActividadEstrategica(RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa) {
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
    }


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
    public DtoActividadEstrategicaResumen listarDominioPorId(EntidadActividadEstrategica entidad,EntidadInformacionActividadEstrategica entidadInformacionActividadEstrategica) {
        return new DtoActividadEstrategicaResumen(entidad.getIdActividadEstrategica(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidadInformacionActividadEstrategica.getDuracion(), entidadInformacionActividadEstrategica.getDiasRestantes(), entidadInformacionActividadEstrategica.getEstado(),
                entidadInformacionActividadEstrategica.getAvance(), entidadInformacionActividadEstrategica.getIdUsuario(), entidadInformacionActividadEstrategica.getIdPat());
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

    public void actualizarEntidad(EntidadActividadEstrategica entidad, ActividadEstrategica actividadEstrategica,
                                  EntidadInformacionActividadEstrategica entidadInformacionActividadEstrategica,
                                  InformacionActividadEstrategica informacionActividadEstrategica) {
        entidad.setFechaInicial(actividadEstrategica.getFechaInicial());
        entidad.setFechaFinal(actividadEstrategica.getFechaFinal());
        entidadInformacionActividadEstrategica.setDuracion(informacionActividadEstrategica.getDuracion());
        entidadInformacionActividadEstrategica.setDiasRestantes(informacionActividadEstrategica.getDiasRestantes());
    }

}
