package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.DetalleProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadDetalleProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioDetalleProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadInformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa.RepositorioInformacionSprintProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa.RepositorioSprintProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class MapeadorDetalleProyectoArea implements MapeadorInfraestructura<EntidadDetalleProyectoArea, DetalleProyectoArea> {
    private final RepositorioInformacionSprintProyectoAreaJpa repositorioInformacionSprintProyectoAreaJpa;
    private final MapeadorProyectoArea mapeadorProyectoArea;
    private final RepositorioSprintProyectoAreaJpa repositorioSprintProyectoAreaJpa;
    private final MapeadorInformacionPat mapeadorInformacionPat;
    private final RepositorioDetalleProyectoAreaJpa repositorioDetalleProyectoAreaJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;

    public MapeadorDetalleProyectoArea(
            RepositorioInformacionSprintProyectoAreaJpa repositorioInformacionSprintProyectoAreaJpa,
            MapeadorProyectoArea mapeadorProyectoArea, RepositorioSprintProyectoAreaJpa repositorioSprintProyectoAreaJpa,
            MapeadorInformacionPat mapeadorInformacionPat, RepositorioDetalleProyectoAreaJpa repositorioDetalleProyectoAreaJpa, ServicioObtenerPorcentaje servicioObtenerPorcentaje) {
        this.repositorioInformacionSprintProyectoAreaJpa = repositorioInformacionSprintProyectoAreaJpa;
        this.mapeadorProyectoArea = mapeadorProyectoArea;
        this.repositorioSprintProyectoAreaJpa = repositorioSprintProyectoAreaJpa;
        this.mapeadorInformacionPat = mapeadorInformacionPat;
        this.repositorioDetalleProyectoAreaJpa = repositorioDetalleProyectoAreaJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
    }
    @Override
    public DetalleProyectoArea mapeadorDominio(EntidadDetalleProyectoArea entidad) {
        return new DetalleProyectoArea(entidad.getDuracion(), entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(),
                entidad.getPorcentajeCumplimiento());
    }
    @Override
    public EntidadDetalleProyectoArea mapeadorEntidad(DetalleProyectoArea dominio) {
        return new EntidadDetalleProyectoArea(dominio.getDuracion(), dominio.getPorcentajeReal(), dominio.getPorcentajeEsperado(),
                dominio.getPorcentajeCumplimiento());
    }

    public void actualizarPorcentajeAvance(EntidadDetalleProyectoArea entidad, Long idProyectoArea) {
        List<EntidadSprintProyectoArea> sprintProyectoAreas = this.repositorioSprintProyectoAreaJpa.findByIdProyectoArea(idProyectoArea);
        // Filtrar los sprints del proyecto del área por la fecha inicial
        List<EntidadSprintProyectoArea> sprintProyectoAreasFiltradas = sprintProyectoAreas.stream()
                .filter(sprint -> sprint.getFechaInicial().isBefore(LocalDate.now()))
                .toList();
        List<EntidadInformacionSprintProyectoArea> informacionSprintProyectoArea = this.repositorioInformacionSprintProyectoAreaJpa.
                findAll()
                .stream()
                .filter(e -> sprintProyectoAreasFiltradas.stream()
                        .anyMatch(sprintProyectoArea -> sprintProyectoArea.getIdSprintProyectoArea().equals(e.getIdInformacionSprintProyectoArea())))
                .toList();

        long totalSprintProyectoAreas = sprintProyectoAreasFiltradas.size();
        double sumaSprintProyectoArea = informacionSprintProyectoArea.stream().mapToDouble(EntidadInformacionSprintProyectoArea::getPorcentajeReal).sum();

        if (totalSprintProyectoAreas > 0) {
            double nuevoAvance = (sumaSprintProyectoArea / totalSprintProyectoAreas);
            entidad.setPorcentajeReal(nuevoAvance);
            entidad.setIdDetalleProyectoArea(idProyectoArea);
            entidad.setPorcentajeEsperado(entidad.getPorcentajeEsperado());
            entidad.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(entidad.getPorcentajeReal(),entidad.getPorcentajeEsperado()));
            repositorioDetalleProyectoAreaJpa.save(entidad);
            var idPat = mapeadorProyectoArea.obtenerProyectoAreaRelacionadoConElProyecto(idProyectoArea).getIdPat();
            var entidadActividad = mapeadorInformacionPat.obtenerTodaEntidadPat(idPat);
            mapeadorInformacionPat.actualizarPorcentajeAvance(entidadActividad,idPat);
        }
    }
    public EntidadDetalleProyectoArea obtenerTodaEntidadProyecto(Long idProyectoArea) {
        var entidad = repositorioDetalleProyectoAreaJpa.findById(idProyectoArea);
        return new EntidadDetalleProyectoArea(idProyectoArea,entidad.orElseThrow().getDuracion()
                ,entidad.orElseThrow().getPorcentajeReal(),
                entidad.orElseThrow().getPorcentajeEsperado(),
                entidad.orElseThrow().getPorcentajeCumplimiento());
    }


}
