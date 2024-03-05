package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador;
import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class MapeadorPat implements MapeadorInfraestructura<EntidadPat, Pat> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    public MapeadorPat(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioInformacionPatJpa repositorioInformacionPatJpa, ServicioObtenerPorcentaje servicioObtenerPorcentaje, ServicioCalcularDuracionDias servicioCalcularDuracionDias, RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa, RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa, RepositorioPatJpa repositorioPatJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioPatJpa = repositorioPatJpa;
    }

    @Override
    public Pat mapeadorDominio(EntidadPat entidad) {
        return new Pat(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro(),
                entidad.getPorcentajePat(), entidad.getIdUsuario());
    }
    @Override
    public EntidadPat mapeadorEntidad(Pat dominio) {
        var idUsuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();

        return new EntidadPat(dominio.getNombre(), dominio.getFechaAnual(),dominio.getFechaRegistro(),
                dominio.getPorcentajePat(), idUsuario);
    }
    public DtoPatResumen patDominio(EntidadPat entidad, EntidadInformacionPat entidadInformacionPat) {
        DtoDireccion dtoDireccion = new DtoDireccion();
        dtoDireccion.setNombre(entidadInformacionPat.getDireccion().getNombre());

        return new DtoPatResumen(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro(),
                entidad.getPorcentajePat(),entidadInformacionPat.getPorcentajeReal(), entidadInformacionPat.getPorcentajeEsperado(),
                entidadInformacionPat.getPorcentajeCumplimiento(),entidadInformacionPat.getFechaInicial(),
                entidadInformacionPat.getFechaFinal(),dtoDireccion,entidad.getIdUsuario());
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

            dto.setFechaInicial(infEntidad.orElseThrow().getFechaInicial());
            dto.setFechaFinal(infEntidad.orElseThrow().getFechaFinal());
            dto.setPorcentajeReal(infEntidad.orElseThrow().getPorcentajeReal());
            var porcentajeEsperado = servicioObtenerPorcentaje.obtenerPorcentajeEsperado(
                    infEntidad.orElseThrow().getFechaInicial(),servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal()));
            dto.setPorcentajeEsperado(Math.min(porcentajeEsperado, Mensaje.PORCENTAJE));
            dto.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(dto.getPorcentajeReal(),dto.getPorcentajeEsperado()));

            DtoDireccion dtoDireccion = new DtoDireccion();
            dtoDireccion.setNombre(infEntidad.orElseThrow().getDireccion().getNombre());
            dto.setDireccion(dtoDireccion);

            dto.setPorcentajePat(actualizarPorcentajePat(entidad.getIdPat(),entidad));

            listaDto.add(dto);
        }
        return listaDto;
    }




    public void actualizarEntidad(EntidadPat entidad, Pat pat) {
        entidad.setNombre(pat.getNombre());
        entidad.setFechaAnual(pat.getFechaAnual());
        entidad.setIdUsuario(pat.getIdUsuario());
    }
    public double actualizarPorcentajePat(Long idPat, EntidadPat entidad) {
        List<EntidadActividadEstrategica> actividadEstrategicas = this.repositorioActividadEstrategicaJpa.findByIdPat(idPat);

        // Filtrar las actividades estratégicas por la fecha inicial
        List<EntidadActividadEstrategica> actividadesFiltradas = actividadEstrategicas.stream()
                .filter(actividad -> actividad.getFechaInicial().isBefore(LocalDate.now()))
                .toList();

        // Obtener la información de las actividades filtradas
        List<EntidadInformacionActividadEstrategica> informacionActividadesEstrategicas = actividadesFiltradas.stream()
                .map(actividadEstrategica -> this.repositorioInformacionActividadEstrategicaJpa.findByIdInformacionActividadEstrategica(actividadEstrategica.getIdActividadEstrategica()))
                .flatMap(List::stream)
                .toList();

        // Calcular el porcentaje
        double porcentaje = Mensaje.PORCENTAJE / informacionActividadesEstrategicas.size();

        double sumaActEstrategica = informacionActividadesEstrategicas.stream().mapToDouble(eEstrategica -> eEstrategica.getPorcentajePat() * porcentaje).sum();

        double avanceTotal = sumaActEstrategica/ Mensaje.PORCENTAJE;
        entidad.setPorcentajePat(avanceTotal);
        entidad.setIdPat(idPat);
        repositorioPatJpa.save(entidad);
        return avanceTotal;
    }
    public EntidadPat obtenerPatRelacionadoConPat(Long id){
        return this.repositorioPatJpa.findById(id).orElseThrow();
    }


}
