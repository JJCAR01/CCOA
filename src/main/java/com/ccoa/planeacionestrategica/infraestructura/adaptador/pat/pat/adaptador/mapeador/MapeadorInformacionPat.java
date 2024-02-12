package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.repositorio.jpa.RepositorioDireccionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proceso.adaptador.repositorio.jpa.RepositorioProcesoJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class    MapeadorInformacionPat implements MapeadorInfraestructura<EntidadInformacionPat, InformacionPat> {

    private final RepositorioDireccionJpa repositorioDireccionJpa;
    private final RepositorioActividadGestionJpa repositorioActividadGestionJpa;
    private final RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioProcesoJpa repositorioProcesoJpa;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;

    public MapeadorInformacionPat(RepositorioDireccionJpa repositorioDireccionJpa, RepositorioActividadGestionJpa repositorioActividadGestionJpa,
                                  RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa,
                                  RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa,
                                  RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa, RepositorioProcesoJpa repositorioProcesoJpa,
                                  RepositorioInformacionPatJpa repositorioInformacionPatJpa) {
        this.repositorioDireccionJpa = repositorioDireccionJpa;
        this.repositorioActividadGestionJpa = repositorioActividadGestionJpa;
        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioProcesoJpa = repositorioProcesoJpa;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
    }

    @Override
    public InformacionPat mapeadorDominio(EntidadInformacionPat entidad) {
        Proceso proceso = Proceso.of(entidad.getProceso().getNombre());
        Direccion direccion = Direccion.of(entidad.getDireccion().getNombre());
        return InformacionPat.of(proceso,direccion,entidad.getPorcentajeReal(),
                entidad.getPorcentajeEsperado(), entidad.getPorcentajeCumplimiento(),entidad.getFechaInicial(),entidad.getFechaFinal());
    }

    @Override
    public EntidadInformacionPat mapeadorEntidad(InformacionPat dominio) {
        Proceso proceso = dominio.getProceso();
        Direccion direccion = dominio.getDireccion();

        // Buscar la entidad entidad por nombre
        var entidadProceso = this.repositorioProcesoJpa.findByNombre(proceso.getNombre());
        var entidadDireccion = this.repositorioDireccionJpa.findByNombre(direccion.getNombre());

        // Crear y devolver la entidad EntidadInformacionPat
                return new EntidadInformacionPat(entidadProceso,entidadDireccion, dominio.getPorcentajeReal(),
                dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento(),dominio.getFechaInicial(),dominio.getFechaFinal());
    }

    public void actualizarEntidad(EntidadInformacionPat entidad, InformacionPat informacionPat) {

        Proceso proceso = informacionPat.getProceso();
        Direccion direccion = informacionPat.getDireccion();
        // Buscar la entidad EntidadDireccion por nombre
        var entidadProceso = this.repositorioProcesoJpa.findByNombre(proceso.getNombre());
        var entidadDireccion = this.repositorioDireccionJpa.findByNombre(direccion.getNombre());
        entidad.setProceso(entidadProceso);
        entidad.setDireccion(entidadDireccion);
    }

    public void actualizarPorcentajeAvance(EntidadInformacionPat entidad, Long idPat) {
        List<EntidadActividadGestion> actividadGestiones = this.repositorioActividadGestionJpa.findByIdPat(idPat);
        List<EntidadInformacionActividadGestion> informacionActividadesGestiones = actividadGestiones.stream()
                .map(actividadGestion -> this.repositorioInformacionActividadGestionJpa.findByIdInformacionActividadGestion(actividadGestion.getIdActividadGestion()))
                .flatMap(List::stream).toList();
        List<EntidadActividadEstrategica> actividadEstrategicas = this.repositorioActividadEstrategicaJpa.findByIdPat(idPat);
        List<EntidadInformacionActividadEstrategica> informacionActividadesEstrategicas = actividadEstrategicas.stream()
                .map(actividadEstrategica -> this.repositorioInformacionActividadEstrategicaJpa.findByIdInformacionActividadEstrategica(actividadEstrategica.getIdActividadEstrategica()))
                .flatMap(List::stream).toList();

        double porcentajeActividades = Mensaje.PORCENTAJE / (actividadGestiones.size() + actividadEstrategicas.size());

        double sumaActGestion = informacionActividadesGestiones.stream().mapToDouble(eGestion -> eGestion.getPorcentajeReal() * porcentajeActividades).sum();
        double sumaActEstrategica = informacionActividadesEstrategicas.stream().mapToDouble(eEstrategica -> eEstrategica.getPorcentajeReal() * porcentajeActividades).sum();

        double avanceTotal = (sumaActGestion + sumaActEstrategica)/ Mensaje.PORCENTAJE;
        entidad.setPorcentajeReal(avanceTotal);
        entidad.setIdInformacionPat(idPat);
        repositorioInformacionPatJpa.save(entidad);
    }

    public EntidadInformacionPat obtenerTodaEntidadPat(Long idPat) {
        var entidad = repositorioInformacionPatJpa.findById(idPat);
        return new EntidadInformacionPat(entidad.orElseThrow().getProceso(),entidad.orElseThrow().getDireccion()
                ,entidad.orElseThrow().getPorcentajeReal(),
                entidad.orElseThrow().getPorcentajeEsperado(),
                entidad.orElseThrow().getPorcentajeCumplimiento(),
                entidad.orElseThrow().getFechaInicial(),
                entidad.orElseThrow().getFechaFinal());
    }
}
