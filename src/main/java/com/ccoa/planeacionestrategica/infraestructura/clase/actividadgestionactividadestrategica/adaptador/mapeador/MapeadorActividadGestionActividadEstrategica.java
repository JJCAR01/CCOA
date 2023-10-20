package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.entidad.EntidadActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class MapeadorActividadGestionActividadEstrategica implements MapeadorInfraestructura<EntidadActividadGestionActividadEstrategica, ActividadGestionActividadEstrategica> {
    @Autowired
    private RepositorioInformacionActividadGestionActividadEstrategicaJpa repositorioInformacionActividadGestionActividadEstrategicaJpa;
    @Autowired
    private RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    @Autowired
    private RepositorioUsuarioJpa repositorioUsuarioJpa;

    @Override
    public ActividadGestionActividadEstrategica mapeadorDominio(EntidadActividadGestionActividadEstrategica entidad) {
        return new ActividadGestionActividadEstrategica(entidad.getIdActividadGestionActividadEstrategica(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getIdUsuario(), entidad.getIdActividadEstrategica());
    }
    @Override
    public EntidadActividadGestionActividadEstrategica mapeadorEntidad(ActividadGestionActividadEstrategica dominio) {
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        var actividad = this.repositorioActividadEstrategicaJpa.findById(dominio.getIdActividadEstrategica()).orElseThrow().getIdActividadEstrategica();
        return new EntidadActividadGestionActividadEstrategica(dominio.getNombre(),dominio.getFechaInicial(),dominio.getFechaFinal(), usuario,
                actividad);
    }
    public List<DtoActividadGestionActividadEstrategicaResumen> listarDominio(List<EntidadActividadGestionActividadEstrategica> entidades){
        List<DtoActividadGestionActividadEstrategicaResumen> listaDto = new ArrayList<>();

        for (EntidadActividadGestionActividadEstrategica entidad : entidades) {
            DtoActividadGestionActividadEstrategicaResumen dto = new DtoActividadGestionActividadEstrategicaResumen();
            dto.setIdActividadGestion(entidad.getIdActividadGestionActividadEstrategica());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());

            var infEntidad = repositorioInformacionActividadGestionActividadEstrategicaJpa.findById(entidad.getIdActividadGestionActividadEstrategica());

            dto.setFechaRegistro(infEntidad.orElseThrow().getFechaRegistro());
            dto.setDuracion(infEntidad.orElseThrow().getDuracion());
            dto.setDiasRestantes(infEntidad.orElseThrow().getDiasRestantes());
            dto.setAvance(infEntidad.orElseThrow().getAvance());

            listaDto.add(dto);
        }
        return listaDto;
    }




}
