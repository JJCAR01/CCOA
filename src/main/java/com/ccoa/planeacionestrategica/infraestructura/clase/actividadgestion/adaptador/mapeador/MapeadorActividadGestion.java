package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class MapeadorActividadGestion implements MapeadorInfraestructura<EntidadActividadGestion, ActividadGestion> {
    @Autowired
    private RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    @Autowired
    private RepositorioPatJpa repositorioPatJpa;
    @Autowired
    private RepositorioUsuarioJpa repositorioUsuarioJpa;



    @Override
    public ActividadGestion mapeadorDominio(EntidadActividadGestion entidad) {
        return new ActividadGestion(entidad.getIdActividadGestion(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getIdUsuario(), entidad.getIdPat());
    }

    @Override
    public EntidadActividadGestion mapeadorEntidad(ActividadGestion dominio) {
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        var pat = this.repositorioPatJpa.findById(dominio.getIdPat()).orElseThrow().getIdPat();
        return new EntidadActividadGestion(dominio.getNombre(),dominio.getFechaInicial(),dominio.getFechaFinal(), usuario,
                pat);
    }
    public List<DtoActividadGestionResumen> listarDominio(List<EntidadActividadGestion> entidades){
        List<DtoActividadGestionResumen> listaDto = new ArrayList<>();

        for (EntidadActividadGestion entidad : entidades) {
            DtoActividadGestionResumen dto = new DtoActividadGestionResumen();
            dto.setIdActividadGestion(entidad.getIdActividadGestion());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setIdPat(entidad.getIdPat());

            var infEntidad = repositorioInformacionActividadGestionJpa.findById(entidad.getIdActividadGestion());

            dto.setFechaRegistro(infEntidad.orElseThrow().getFechaRegistro());
            dto.setDuracion(infEntidad.orElseThrow().getDuracion());
            dto.setDiasRestantes(infEntidad.orElseThrow().getDiasRestantes());
            dto.setAvance(infEntidad.orElseThrow().getAvance());

            listaDto.add(dto);
        }
        return listaDto;
    }
}
