package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDuracion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Configuration
public class MapeadorActividadGestion implements MapeadorInfraestructura<EntidadActividadGestion, ActividadGestion> {
    private final RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadGestionJpa repositorioActividadGestionJpa;
    private final ServicioObtenerDuracion servicioObtenerDuracion;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;

    public MapeadorActividadGestion(RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa,
                                    RepositorioPatJpa repositorioPatJpa, RepositorioUsuarioJpa repositorioUsuarioJpa,
                                    RepositorioActividadGestionJpa repositorioActividadGestionJpa, ServicioObtenerDuracion servicioObtenerDuracion, ServicioObtenerPorcentaje servicioObtenerPorcentaje) {
        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadGestionJpa = repositorioActividadGestionJpa;
        this.servicioObtenerDuracion = servicioObtenerDuracion;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
    }

    @Override
    public ActividadGestion mapeadorDominio(EntidadActividadGestion entidad) {
        return new ActividadGestion(entidad.getIdActividadGestion(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getFechaRegistro(),entidad.getIdUsuario(), entidad.getIdPat());
    }

    @Override
    public EntidadActividadGestion mapeadorEntidad(ActividadGestion dominio) {
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        var pat = this.repositorioPatJpa.findById(dominio.getIdPat()).orElseThrow().getIdPat();
        return new EntidadActividadGestion(dominio.getNombre(),dominio.getFechaInicial(),dominio.getFechaFinal(),
                dominio.getFechaRegistro(),usuario,pat);
    }
    public List<DtoActividadGestionResumen> listarDominio(List<EntidadActividadGestion> entidades){
        List<DtoActividadGestionResumen> listaDto = new ArrayList<>();

        for (EntidadActividadGestion entidad : entidades) {
            DtoActividadGestionResumen dto = new DtoActividadGestionResumen();
            dto.setIdActividadGestion(entidad.getIdActividadGestion());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setFechaRegistro(entidad.getFechaRegistro());
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setIdPat(entidad.getIdPat());

            var infEntidad = repositorioInformacionActividadGestionJpa.findById(entidad.getIdActividadGestion());

            dto.setDuracion(infEntidad.orElseThrow().getDuracion());
            dto.setDiasRestantes(infEntidad.orElseThrow().getDiasRestantes());
            dto.setPorcentajeReal(infEntidad.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(infEntidad.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(dto.getPorcentajeReal(),dto.getPorcentajeEsperado()));

            listaDto.add(dto);
        }
        return listaDto;
    }
    public List<DtoActividadGestion> obtenerActividadesGestionParaDuplicar(List<EntidadActividadGestion> entidades){
        List<DtoActividadGestion> listaDto = new ArrayList<>();

        for (EntidadActividadGestion entidad : entidades) {
            DtoActividadGestion dto = new DtoActividadGestion();
            dto.setIdActividadGestion(entidad.getIdActividadGestion());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setIdUsuario(entidad.getIdUsuario());

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
        entidad.setIdUsuario(actividadGestion.getIdUsuario());
        var duracion = obtenerDuracion(entidad.getFechaInicial(),entidad.getFechaFinal());
        entidadInformacionActividadGestion.setDuracion(duracion);
        entidadInformacionActividadGestion.setPorcentajeEsperado(obtenerPorcentajeEsperado(entidad.getFechaInicial(),duracion));
        entidadInformacionActividadGestion.setDiasRestantes(informacionActividadGestion.getDiasRestantes());
    }
    public EntidadActividadGestion obtenerIdPatRelacionadoConElActividadGestion(Long id) {
        return this.repositorioActividadGestionJpa.findById(id).orElse(null);
    }

    public Integer obtenerDuracion(LocalDate fechaInicial, LocalDate fechaFinal){
        return servicioObtenerDuracion.calcular(fechaInicial,fechaFinal);
    }
    public double obtenerPorcentajeEsperado(LocalDate fechaInicial, long duracion){
        return Math.min(servicioObtenerPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion), Mensaje.PORCENTAJE);
    }
}
