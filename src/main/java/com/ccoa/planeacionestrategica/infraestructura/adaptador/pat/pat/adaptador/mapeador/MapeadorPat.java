package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador;
import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioDetalleActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.clasificacion.adaptador.repositorio.jpa.RepositorioClasificacionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadDetallePat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioDetallePatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class MapeadorPat implements MapeadorInfraestructura<EntidadPat, Pat> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioClasificacionJpa repositorioClasificacionJpa;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;
    private final RepositorioDetallePatJpa repositorioDetallePatJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioDetalleActividadEstrategicaJpa repositorioDetalleActividadEstrategicaJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    public MapeadorPat(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioClasificacionJpa repositorioClasificacionJpa, RepositorioInformacionPatJpa repositorioInformacionPatJpa, RepositorioDetallePatJpa repositorioDetallePatJpa,
                       ServicioObtenerPorcentaje servicioObtenerPorcentaje,
                       RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa,
                       RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa, RepositorioDetalleActividadEstrategicaJpa repositorioDetalleActividadEstrategicaJpa, RepositorioPatJpa repositorioPatJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioClasificacionJpa = repositorioClasificacionJpa;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
        this.repositorioDetallePatJpa = repositorioDetallePatJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioDetalleActividadEstrategicaJpa = repositorioDetalleActividadEstrategicaJpa;
        this.repositorioPatJpa = repositorioPatJpa;
    }

    @Override
    public Pat mapeadorDominio(EntidadPat entidad) {
        return new Pat(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro(),
                entidad.getPorcentajePat(), entidad.getIdUsuario(), entidad.getIdClasificacion() );
    }
    @Override
    public EntidadPat mapeadorEntidad(Pat dominio) {
        var idUsuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        var idClasificacion = this.repositorioClasificacionJpa.findById(dominio.getIdClasificacion()).orElseThrow().getIdClasificacion();

        return new EntidadPat(dominio.getNombre(), dominio.getFechaAnual(),dominio.getFechaRegistro(),
                dominio.getPorcentajePat(), idUsuario, idClasificacion);
    }
    public DtoPatResumen patDominio(EntidadPat entidad, EntidadInformacionPat entidadInformacionPat, EntidadDetallePat detallePat) {
        DtoDireccion dtoDireccion = new DtoDireccion();
        dtoDireccion.setNombre(entidadInformacionPat.getDireccion().getNombre());

        return new DtoPatResumen(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro(),
                entidad.getPorcentajePat(),entidadInformacionPat.getPorcentajeReal(),
                entidadInformacionPat.getPorcentajeEsperado(),entidadInformacionPat.getPorcentajeCumplimiento(),
                entidadInformacionPat.getPorcentajeKPI(),entidadInformacionPat.getFechaInicial(),entidadInformacionPat.getFechaFinal(),
                detallePat.isEstrategica(),detallePat.isDeProceso(), dtoDireccion,entidad.getIdUsuario(), entidad.getIdClasificacion());
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
            dto.setIdClasificacion(entidad.getIdClasificacion());

            var infEntidad = repositorioInformacionPatJpa.findById(entidad.getIdPat());

            dto.setFechaInicial(infEntidad.orElseThrow().getFechaInicial());
            dto.setFechaFinal(infEntidad.orElseThrow().getFechaFinal());
            dto.setPorcentajeReal(infEntidad.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(infEntidad.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(dto.getPorcentajeReal(),dto.getPorcentajeEsperado()));
            dto.setPorcentajeKPI(infEntidad.orElseThrow().getPorcentajeKPI());

            DtoDireccion dtoDireccion = new DtoDireccion();
            dtoDireccion.setNombre(infEntidad.orElseThrow().getDireccion().getNombre());
            dto.setDireccion(dtoDireccion);

            dto.setPorcentajePat(entidad.getPorcentajePat());

            Optional<EntidadDetallePat> detallePatOptional = repositorioDetallePatJpa.findById(entidad.getIdPat());

            if (detallePatOptional.isPresent()) {
                EntidadDetallePat detallePat = detallePatOptional.get();
                dto.setDeProceso(detallePat.isDeProceso());
                dto.setEstrategica(detallePat.isEstrategica());
            }

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadPat entidad, Pat pat) {
        entidad.setNombre(pat.getNombre());
        entidad.setFechaAnual(pat.getFechaAnual());
        entidad.setIdUsuario(pat.getIdUsuario());
        entidad.setIdClasificacion(pat.getIdClasificacion());
    }
    public void actualizarPorcentajePat(EntidadPat entidad, EntidadInformacionPat entidadInformacionPat) {
        List<EntidadActividadEstrategica> actividadEstrategicas = this.repositorioActividadEstrategicaJpa.findByIdPat(entidad.getIdPat());

        LocalDate fechaActual = LocalDate.now();
        // Filtrar las actividades estratégicas por la fecha inicial
        List<EntidadActividadEstrategica> actividadesFiltradas = actividadEstrategicas.stream()
                .filter(actividad -> actividad.getFechaInicial().isBefore(fechaActual))
                .toList();

        // Obtener la información de las actividades filtradas
        List<EntidadInformacionActividadEstrategica> informacionActividadesEstrategicas = actividadesFiltradas.stream()
                .map(actividadEstrategica -> this.repositorioInformacionActividadEstrategicaJpa.findByIdInformacionActividadEstrategica(actividadEstrategica.getIdActividadEstrategica()))
                .flatMap(List::stream)
                .toList();

        List<EntidadDetalleActividadEstrategica> detalleActividadEstrategicas = actividadesFiltradas.stream()
                .map(actividadEstrategica -> this.repositorioDetalleActividadEstrategicaJpa.findByIdDetalleActividadEstrategica(actividadEstrategica.getIdActividadEstrategica()))
                .flatMap(List::stream)
                .toList();

        // Calcular el porcentaje
        double porcentaje = informacionActividadesEstrategicas.size();

        double sumaActEstrategicaPorcentajeKPI = detalleActividadEstrategicas.stream().mapToDouble(EntidadDetalleActividadEstrategica::getPorcentajeMeta).sum();
        double sumaActEstrategicaPorcentajePat = informacionActividadesEstrategicas.stream().mapToDouble(EntidadInformacionActividadEstrategica::getPorcentajePat).sum();

        double avanceTotal = (sumaActEstrategicaPorcentajePat / porcentaje);
        double promedioKPI = (sumaActEstrategicaPorcentajeKPI / porcentaje);

        entidadInformacionPat.setPorcentajeKPI(promedioKPI);

        repositorioInformacionPatJpa.save(entidadInformacionPat);

        entidad.setPorcentajePat(avanceTotal);
        entidad.setIdPat(entidad.getIdPat());
        repositorioPatJpa.save(entidad);
    }
    public EntidadPat obtenerPatRelacionadoConPat(Long id){
        return this.repositorioPatJpa.findById(id).orElseThrow();
    }


}
