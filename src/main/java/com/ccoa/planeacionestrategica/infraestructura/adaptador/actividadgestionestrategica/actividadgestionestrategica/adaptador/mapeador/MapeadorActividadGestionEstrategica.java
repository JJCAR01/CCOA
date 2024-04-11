package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.ActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.InformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDuracion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioActividadGestionEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad.EntidadActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad.EntidadInformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Configuration
public class MapeadorActividadGestionEstrategica implements MapeadorInfraestructura<EntidadActividadGestionEstrategica, ActividadGestionEstrategica> {
    private final RepositorioActividadGestionEstrategicaJpa repositorioActividadGestionEstrategicaJpa;
    private final RepositorioInformacionActividadGestionEstrategicaJpa repositorioInformacionActividadGestionEstrategicaJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final ServicioObtenerDuracion servicioObtenerDuracion;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;

    public MapeadorActividadGestionEstrategica(RepositorioActividadGestionEstrategicaJpa repositorioActividadGestionEstrategicaJpa, RepositorioInformacionActividadGestionEstrategicaJpa repositorioInformacionActividadGestionEstrategicaJpa, RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa,
                                               RepositorioUsuarioJpa repositorioUsuarioJpa, ServicioObtenerDuracion servicioObtenerDuracion, ServicioObtenerPorcentaje servicioObtenerPorcentaje) {
        this.repositorioActividadGestionEstrategicaJpa = repositorioActividadGestionEstrategicaJpa;
        this.repositorioInformacionActividadGestionEstrategicaJpa = repositorioInformacionActividadGestionEstrategicaJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.servicioObtenerDuracion = servicioObtenerDuracion;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
    }

    @Override
    public ActividadGestionEstrategica mapeadorDominio(EntidadActividadGestionEstrategica entidad) {
        return new ActividadGestionEstrategica(entidad.getIdActividadGestionEstrategica(), entidad.getNombre(),
                entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getFechaRegistro(), entidad.getIdUsuario(), entidad.getIdActividadEstrategica());
    }
    @Override
    public EntidadActividadGestionEstrategica mapeadorEntidad(ActividadGestionEstrategica dominio) {
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        var actividad = this.repositorioActividadEstrategicaJpa.findById(dominio.getIdActividadEstrategica()).orElseThrow().getIdActividadEstrategica();
        return new EntidadActividadGestionEstrategica(dominio.getNombre(),dominio.getFechaInicial(),dominio.getFechaFinal(),
                dominio.getFechaRegistro() ,usuario, actividad);
    }
    public List<DtoActividadGestionEstrategicaResumen> listarDominio(List<EntidadActividadGestionEstrategica> entidades){
        List<DtoActividadGestionEstrategicaResumen> listaDto = new ArrayList<>();

        for (EntidadActividadGestionEstrategica entidad : entidades) {
            DtoActividadGestionEstrategicaResumen dto = new DtoActividadGestionEstrategicaResumen();
            dto.setIdActividadGestionEstrategica(entidad.getIdActividadGestionEstrategica());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setFechaRegistro(entidad.getFechaRegistro());
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());

            var infEntidad = repositorioInformacionActividadGestionEstrategicaJpa.findById(entidad.getIdActividadGestionEstrategica());

            dto.setDuracion(infEntidad.orElseThrow().getDuracion());
            dto.setDiasRestantes(infEntidad.orElseThrow().getDiasRestantes());
            dto.setPorcentajeReal(infEntidad.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(infEntidad.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(dto.getPorcentajeReal(),dto.getPorcentajeEsperado()));

            listaDto.add(dto);
        }
        return listaDto;
    }
    public List<DtoActividadGestionEstrategica> obtenerActividadParaDuplicar(List<EntidadActividadGestionEstrategica> entidades){
        List<DtoActividadGestionEstrategica> listaDto = new ArrayList<>();

        for (EntidadActividadGestionEstrategica entidad : entidades) {
            DtoActividadGestionEstrategica dto = new DtoActividadGestionEstrategica();
            dto.setIdActividadGestionEstrategica(entidad.getIdActividadGestionEstrategica());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setIdUsuario(entidad.getIdUsuario());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public List<DtoIdsActividadGestionEstrategica> listarPorIds(List<EntidadActividadGestionEstrategica> entidades){
        List<DtoIdsActividadGestionEstrategica> listaDto = new ArrayList<>();

        for (EntidadActividadGestionEstrategica entidad : entidades) {
            DtoIdsActividadGestionEstrategica dto = new DtoIdsActividadGestionEstrategica();
            dto.setIdActividadGestionEstrategica(entidad.getIdActividadGestionEstrategica());
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());

            var infEntidad = repositorioInformacionActividadGestionEstrategicaJpa.findById(entidad.getIdActividadGestionEstrategica());

            dto.setIdInformacionActividadGestionEstrategica(infEntidad.orElseThrow().getIdInformacionActividadGestionEstrategica());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadActividadGestionEstrategica entidad, ActividadGestionEstrategica actividadGestion,
                                  EntidadInformacionActividadGestionEstrategica entidadInformacionActividadGestion,
                                  InformacionActividadGestionEstrategica informacionActividadGestion) {
        entidad.setNombre(actividadGestion.getNombre());
        entidad.setFechaInicial(actividadGestion.getFechaInicial());
        entidad.setFechaFinal(actividadGestion.getFechaFinal());
        entidad.setIdUsuario(actividadGestion.getIdUsuario());
        var duracion = obtenerDuracion(entidad.getFechaInicial(),entidad.getFechaFinal());
        entidadInformacionActividadGestion.setDuracion(duracion);
        entidadInformacionActividadGestion.setPorcentajeEsperado(obtenerPorcentajeEsperado(entidad.getFechaInicial(),duracion));
        entidadInformacionActividadGestion.setDiasRestantes(informacionActividadGestion.getDiasRestantes());
    }
    public EntidadActividadGestionEstrategica obtenerIdProyectoRelacionadoConElSprint(Long id){
        return this.repositorioActividadGestionEstrategicaJpa.findById(id).orElseThrow();
    }

    public Integer obtenerDuracion(LocalDate fechaInicial, LocalDate fechaFinal){
        return servicioObtenerDuracion.calcular(fechaInicial,fechaFinal);
    }
    public double obtenerPorcentajeEsperado(LocalDate fechaInicial, long duracion){
        return Math.min(servicioObtenerPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion), Mensaje.PORCENTAJE);
    }
}
