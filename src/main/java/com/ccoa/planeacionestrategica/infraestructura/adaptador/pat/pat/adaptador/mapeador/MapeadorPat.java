package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador;
import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadDetallePat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioDetallePatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorPat implements MapeadorInfraestructura<EntidadPat, Pat> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;
    private final RepositorioDetallePatJpa repositorioDetallePatJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    public MapeadorPat(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioInformacionPatJpa repositorioInformacionPatJpa, RepositorioDetallePatJpa repositorioDetallePatJpa,
                       ServicioObtenerPorcentaje servicioObtenerPorcentaje,
                       RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa,
                       RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa, RepositorioPatJpa repositorioPatJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
        this.repositorioDetallePatJpa = repositorioDetallePatJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
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
    public DtoPatResumen patDominio(EntidadPat entidad, EntidadInformacionPat entidadInformacionPat, EntidadDetallePat detallePat) {
        DtoDireccion dtoDireccion = new DtoDireccion();
        dtoDireccion.setNombre(entidadInformacionPat.getDireccion().getNombre());

        return new DtoPatResumen(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro(),
                entidad.getPorcentajePat(),entidadInformacionPat.getPorcentajeReal(), entidadInformacionPat.getPorcentajeEsperado(),
                entidadInformacionPat.getPorcentajeCumplimiento(),entidadInformacionPat.getFechaInicial(),
                entidadInformacionPat.getFechaFinal(), detallePat.isEstrategica(), detallePat.isDeProceso(), dtoDireccion,entidad.getIdUsuario());
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
            dto.setPorcentajeEsperado(infEntidad.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(dto.getPorcentajeReal(),dto.getPorcentajeEsperado()));

            DtoDireccion dtoDireccion = new DtoDireccion();
            dtoDireccion.setNombre(infEntidad.orElseThrow().getDireccion().getNombre());
            dto.setDireccion(dtoDireccion);

            dto.setPorcentajePat(entidad.getPorcentajePat());

            var detalleEntidad = repositorioDetallePatJpa.findById(entidad.getIdPat());


            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadPat entidad, Pat pat) {
        entidad.setNombre(pat.getNombre());
        entidad.setFechaAnual(pat.getFechaAnual());
        entidad.setIdUsuario(pat.getIdUsuario());
    }
    public void actualizarPorcentajePat(EntidadPat entidad) {
        List<EntidadActividadEstrategica> actividadEstrategicas = this.repositorioActividadEstrategicaJpa.findByIdPat(entidad.getIdPat());

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
        double porcentaje = Mensaje.PORCENTAJE * informacionActividadesEstrategicas.size();

        double sumaActEstrategica = informacionActividadesEstrategicas.stream().mapToDouble(EntidadInformacionActividadEstrategica::getPorcentajePat).sum();

        double avanceTotal = (sumaActEstrategica/ porcentaje) * Mensaje.PORCENTAJE;
        entidad.setPorcentajePat(avanceTotal);
        entidad.setIdPat(entidad.getIdPat());
        repositorioPatJpa.save(entidad);
    }
    public EntidadPat obtenerPatRelacionadoConPat(Long id){
        return this.repositorioPatJpa.findById(id).orElseThrow();
    }


}
