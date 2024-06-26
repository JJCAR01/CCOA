package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDuracion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadDetallePat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.repositorio.jpa.RepositorioDireccionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioDetallePatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadDetalleProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadInformacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioDetalleProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioInformacionProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Configuration
public class    MapeadorInformacionPat implements MapeadorInfraestructura<EntidadInformacionPat, InformacionPat> {

    private final RepositorioDireccionJpa repositorioDireccionJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final ServicioObtenerDuracion servicioObtenerDuracion;
    private final RepositorioActividadGestionJpa repositorioActividadGestionJpa;
    private final RepositorioInformacionProyectoAreaJpa repositorioInformacionProyectoAreaJpa;
    private final RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioProyectoAreaJpa repositorioProyectoAreaJpa;
    private final RepositorioDetalleProyectoAreaJpa repositorioDetalleProyectoAreaJpa;
    private final RepositorioDetallePatJpa repositorioDetallePatJpa;
    private final MapeadorPat mapeadorPat;
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;

    public MapeadorInformacionPat(RepositorioDireccionJpa repositorioDireccionJpa, ServicioObtenerPorcentaje servicioObtenerPorcentaje, ServicioObtenerDuracion servicioObtenerDuracion, RepositorioActividadGestionJpa repositorioActividadGestionJpa,
                                  RepositorioInformacionProyectoAreaJpa repositorioInformacionProyectoAreaJpa, RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa,
                                  RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa,
                                  RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa, RepositorioProyectoAreaJpa repositorioProyectoAreaJpa, RepositorioDetalleProyectoAreaJpa repositorioDetalleProyectoAreaJpa, RepositorioDetallePatJpa repositorioDetallePatJpa,
                                  MapeadorPat mapeadorPat, RepositorioPatJpa repositorioPatJpa, RepositorioInformacionPatJpa repositorioInformacionPatJpa) {
        this.repositorioDireccionJpa = repositorioDireccionJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.servicioObtenerDuracion = servicioObtenerDuracion;
        this.repositorioActividadGestionJpa = repositorioActividadGestionJpa;
        this.repositorioInformacionProyectoAreaJpa = repositorioInformacionProyectoAreaJpa;
        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioProyectoAreaJpa = repositorioProyectoAreaJpa;
        this.repositorioDetalleProyectoAreaJpa = repositorioDetalleProyectoAreaJpa;
        this.repositorioDetallePatJpa = repositorioDetallePatJpa;
        this.mapeadorPat = mapeadorPat;
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
    }

    @Override
    public InformacionPat mapeadorDominio(EntidadInformacionPat entidad) {
        Direccion direccion = Direccion.of(entidad.getDireccion().getNombre());
        return InformacionPat.of(direccion,entidad.getPorcentajeReal(),
                entidad.getPorcentajeEsperado(), entidad.getPorcentajeCumplimiento(),entidad.getPorcentajeKPI(),
                entidad.getFechaInicial(),entidad.getFechaFinal());
    }

    @Override
    public EntidadInformacionPat mapeadorEntidad(InformacionPat dominio) {
        Direccion direccion = dominio.getDireccion();

        // Buscar la entidad entidad por descripcion
        var entidadDireccion = this.repositorioDireccionJpa.findByNombre(direccion.getNombre());

        // Crear y devolver la entidad EntidadInformacionPat
        return new EntidadInformacionPat(entidadDireccion, dominio.getPorcentajeReal(),
                dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento(),
                dominio.getPorcentajeKPI(),dominio.getFechaInicial(),dominio.getFechaFinal());
    }

    public void actualizarEntidad(EntidadInformacionPat entidad, InformacionPat informacionPat) {

        Direccion direccion = informacionPat.getDireccion();
        // Buscar la entidad EntidadDireccion por descripcion
        var entidadDireccion = this.repositorioDireccionJpa.findByNombre(direccion.getNombre());
        entidad.setDireccion(entidadDireccion);
        entidad.setFechaInicial(informacionPat.getFechaInicial());
        entidad.setFechaFinal(informacionPat.getFechaFinal());
        var duracion = obtenerDuracion(entidad.getFechaInicial(),entidad.getFechaFinal());
        entidad.setPorcentajeEsperado(obtenerPorcentajeEsperado(entidad.getFechaInicial(),duracion));

    }

    public void actualizarPorcentajeAvance(EntidadInformacionPat entidad, Long idPat) {
        Optional<EntidadDetallePat> detallePatOptional = repositorioDetallePatJpa.findById(idPat);

        if (detallePatOptional.isPresent()) {
            EntidadDetallePat detallePat = detallePatOptional.get();

            if (detallePat.isEstrategica()){
                List<EntidadActividadEstrategica> actividadEstrategicas = this.repositorioActividadEstrategicaJpa.findByIdPat(idPat);
                // Filtrar las actividades de Gestion por la fecha inicial
                List<EntidadActividadEstrategica> actividadEstrategicasFiltradas = actividadEstrategicas.stream()
                        .filter(actividadEstrategica -> actividadEstrategica.getFechaInicial().isBefore(LocalDate.now()))
                        .toList();
                List<EntidadInformacionActividadEstrategica> informacionActividadesEstrategicas = actividadEstrategicasFiltradas.stream()
                        .map(actividadEstrategica -> this.repositorioInformacionActividadEstrategicaJpa.findByIdInformacionActividadEstrategica(actividadEstrategica.getIdActividadEstrategica()))
                        .flatMap(List::stream).toList();

                double porcentaje = actividadEstrategicasFiltradas.size();

                double sumaActEstrategica = informacionActividadesEstrategicas.stream().mapToDouble(EntidadInformacionActividadEstrategica::getPorcentajeReal).sum();
                double avanceTotal = sumaActEstrategica/ porcentaje;

                actualizarEntidadPat(entidad,idPat,avanceTotal);


            } else if (detallePat.isDeProceso()) {
                List<EntidadActividadGestion> actividadGestiones = this.repositorioActividadGestionJpa.findByIdPat(idPat);
                // Filtrar las actividades de Gestion por la fecha inicial
                List<EntidadActividadGestion> actividadGestionesFiltradas = actividadGestiones.stream()
                        .filter(actividadGestion -> actividadGestion.getFechaInicial().isBefore(LocalDate.now()))
                        .toList();
                List<EntidadInformacionActividadGestion> informacionActividadesGestiones = actividadGestionesFiltradas.stream()
                        .map(actividadGestion -> this.repositorioInformacionActividadGestionJpa.findByIdInformacionActividadGestion(actividadGestion.getIdActividadGestion()))
                        .flatMap(List::stream).toList();

                List<EntidadProyectoArea> proyectosArea = this.repositorioProyectoAreaJpa.findByIdPat(idPat);
                List<EntidadInformacionProyectoArea> informacionProyectos = this.repositorioInformacionProyectoAreaJpa.
                        findAll()
                        .stream()
                        .filter(e -> proyectosArea.stream()
                                .anyMatch(proyecto -> proyecto.getIdProyectoArea().equals(e.getIdInformacionProyectoArea())))
                        .toList();
                // Filtrar las actividades de Gestion estratégica por la fecha inicial
                List<EntidadInformacionProyectoArea> informacionProyectosFiltradas = informacionProyectos.stream()
                        .filter(actividadGestion -> actividadGestion.getFechaInicial().isBefore(LocalDate.now()))
                        .toList();
                List<EntidadDetalleProyectoArea> detalleProyectosArea = informacionProyectosFiltradas.stream()
                        .map(proyecto -> this.repositorioDetalleProyectoAreaJpa.findByIdDetalleProyectoArea(proyecto.getIdInformacionProyectoArea()))
                        .flatMap(List::stream).toList();

                double porcentaje = (actividadGestionesFiltradas.size() + proyectosArea.size());
                double sumaProyectos = detalleProyectosArea.stream().mapToDouble(EntidadDetalleProyectoArea::getPorcentajeReal).sum();
                double sumaActGestion = informacionActividadesGestiones.stream().mapToDouble(EntidadInformacionActividadGestion::getPorcentajeReal).sum();
                double avanceTotal = (sumaActGestion + sumaProyectos)/ porcentaje;

                actualizarEntidadPat(entidad,idPat,avanceTotal);
            }

        }

    }

    private void actualizarEntidadPat(EntidadInformacionPat entidad, Long idPat, double avanceTotal) {
        entidad.setPorcentajeReal(avanceTotal);
        entidad.setIdInformacionPat(idPat);
        var entidadPat = mapeadorPat.obtenerPatRelacionadoConPat(idPat);
        entidad.setPorcentajeEsperado(entidad.getPorcentajeEsperado());
        entidad.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado()));
        entidadPat.setIdPat(idPat);
        repositorioPatJpa.save(entidadPat);
        repositorioInformacionPatJpa.save(entidad);
    }

    public EntidadInformacionPat obtenerTodaEntidadPat(Long idPat) {
        var entidad = repositorioInformacionPatJpa.findById(idPat);

        var entidadDireccion = this.repositorioDireccionJpa.findByNombre(entidad.orElseThrow().getDireccion().getNombre());

        // Crear y devolver la entidad EntidadInformacionPat
        return new EntidadInformacionPat(idPat,entidadDireccion
                ,entidad.orElseThrow().getPorcentajeReal(),
                entidad.orElseThrow().getPorcentajeEsperado(),
                entidad.orElseThrow().getPorcentajeCumplimiento(),
                entidad.orElseThrow().getPorcentajeKPI(),
                entidad.orElseThrow().getFechaInicial(),
                entidad.orElseThrow().getFechaFinal());
    }

    public long obtenerDuracion(LocalDate fechaInicial, LocalDate fechaFinal){
        return servicioObtenerDuracion.calcular(fechaInicial,fechaFinal);
    }
    public double obtenerPorcentajeEsperado(LocalDate fechaInicial, long duracion){
        return Math.min(servicioObtenerPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion), Mensaje.PORCENTAJE);
    }
}
