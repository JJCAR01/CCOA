package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class MapeadorActividadGestion implements MapeadorInfraestructura<EntidadActividadGestion, ActividadGestion> {
    private final RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadGestionJpa repositorioActividadGestionJpa;
    private final ServicioObtenerDiasRestantes servicioObtenerDiasRestantes;

    public MapeadorActividadGestion(RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa,
                                    RepositorioPatJpa repositorioPatJpa, RepositorioUsuarioJpa repositorioUsuarioJpa,
                                    RepositorioActividadGestionJpa repositorioActividadGestionJpa, ServicioObtenerDiasRestantes servicioObtenerDiasRestantes) {
        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadGestionJpa = repositorioActividadGestionJpa;
        this.servicioObtenerDiasRestantes = servicioObtenerDiasRestantes;
    }

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
            dto.setDiasRestantes(servicioObtenerDiasRestantes.calcular(entidad.getFechaFinal()));
            dto.setAvance(infEntidad.orElseThrow().getAvance());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public List<DtoIdsActividadGestion> listarPorIds(List<EntidadActividadGestion> entidades){
        List<DtoIdsActividadGestion> listaDto = new ArrayList<>();

        for (EntidadActividadGestion entidad : entidades) {
            DtoIdsActividadGestion dto = new DtoIdsActividadGestion();
            dto.setIdActividadGestion(entidad.getIdActividadGestion());
            dto.setIdPat(entidad.getIdPat());

            var infEntidad = repositorioInformacionActividadGestionJpa.findById(entidad.getIdActividadGestion());

            dto.setIdInformacionActividadGestion(infEntidad.orElseThrow().getIdInformacionActividadGestion());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadActividadGestion entidad, ActividadGestion actividadGestion,
                                  EntidadInformacionActividadGestion entidadInformacionActividadGestion,
                                  InformacionActividadGestion informacionActividadGestion) {
        entidad.setNombre(actividadGestion.getNombre());
        entidad.setFechaInicial(actividadGestion.getFechaInicial());
        entidad.setFechaFinal(actividadGestion.getFechaFinal());
        entidadInformacionActividadGestion.setDuracion(informacionActividadGestion.getDuracion());
        entidadInformacionActividadGestion.setDiasRestantes(informacionActividadGestion.getDiasRestantes());
    }
    public EntidadPat obtenerGestion(EntidadInformacionActividadGestion informacionActividadGestion){
        var entidad = this.repositorioActividadGestionJpa.findById(informacionActividadGestion.getIdInformacionActividadGestion());
        var entidadPat = this.repositorioPatJpa.findById(entidad.orElseThrow().getIdPat());
        return obtenerActividadGestionRelacionado(entidadPat.orElseThrow().getIdPat());
    }
    private EntidadPat obtenerActividadGestionRelacionado(Long id) {
        return this.repositorioPatJpa.findById(id).orElse(null);
    }


}
