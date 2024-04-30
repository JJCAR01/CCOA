package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador.MapeadorInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioDetalleProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadInformacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioInformacionSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class MapeadorDetalleProyecto implements MapeadorInfraestructura<EntidadDetalleProyecto, DetalleProyecto> {
    private final RepositorioInformacionSprintJpa repositorioInformacionSprintJpa;
    private final MapeadorProyecto mapeadorProyecto;
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica;
    private final RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;

    public MapeadorDetalleProyecto(
            RepositorioInformacionSprintJpa repositorioInformacionSprintJpa,
            MapeadorProyecto mapeadorProyecto,
            RepositorioSprintJpa repositorioSprintJpa, MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica,
            RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa, ServicioObtenerPorcentaje servicioObtenerPorcentaje) {
        this.repositorioInformacionSprintJpa = repositorioInformacionSprintJpa;
        this.mapeadorProyecto = mapeadorProyecto;
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.mapeadorInformacionActividadEstrategica = mapeadorInformacionActividadEstrategica;
        this.repositorioDetalleProyectoJpa = repositorioDetalleProyectoJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
    }
    @Override
    public DetalleProyecto mapeadorDominio(EntidadDetalleProyecto entidad) {
        return new DetalleProyecto(entidad.getDuracion(), entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(),
                entidad.getPorcentajeCumplimiento());
    }
    @Override
    public EntidadDetalleProyecto mapeadorEntidad(DetalleProyecto dominio) {
        return new EntidadDetalleProyecto(dominio.getDuracion(), dominio.getPorcentajeReal(), dominio.getPorcentajeEsperado(),
                dominio.getPorcentajeCumplimiento());
    }

    public void actualizarPorcentajeAvance(EntidadDetalleProyecto entidad, Long idProyecto) {
        List<EntidadSprint> sprints = this.repositorioSprintJpa.findByIdProyecto(idProyecto);
        // Filtrar los sprints por la fecha inicial
        List<EntidadSprint> sprintsFiltradas = sprints.stream()
                .filter(sprint -> sprint.getFechaInicial().isBefore(LocalDate.now()))
                .toList();
        List<EntidadInformacionSprint> informacionSprint = this.repositorioInformacionSprintJpa.
                findAll()
                .stream()
                .filter(e -> sprintsFiltradas.stream()
                        .anyMatch(sprint -> sprint.getIdSprint().equals(e.getIdInformacionSprint())))
                .toList();

        long totalSprints = sprintsFiltradas.size();
        double sumaSprint = informacionSprint.stream().mapToDouble(EntidadInformacionSprint::getPorcentajeReal).sum();

        if (totalSprints > 0) {
            double nuevoAvance = (sumaSprint / totalSprints);
            entidad.setPorcentajeReal(nuevoAvance);
            entidad.setIdDetalleProyecto(idProyecto);
            entidad.setPorcentajeEsperado(entidad.getPorcentajeEsperado());
            entidad.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(entidad.getPorcentajeReal(),entidad.getPorcentajeEsperado()));
            repositorioDetalleProyectoJpa.save(entidad);
            var idActividadEstrategica = mapeadorProyecto.obtenerActividadEstrategicaRelacionadoConElProyecto(idProyecto).getIdActividadEstrategica();
            var entidadActividad = mapeadorInformacionActividadEstrategica.obtenerTodaEntidadActividadEstrategica(idActividadEstrategica);
            mapeadorInformacionActividadEstrategica.actualizarPorcentajeAvance(entidadActividad,idActividadEstrategica);
        }
    }
    public EntidadDetalleProyecto obtenerTodaEntidadProyecto(Long idProyecto) {
        var entidad = repositorioDetalleProyectoJpa.findById(idProyecto);
        return new EntidadDetalleProyecto(idProyecto, entidad.orElseThrow().getDuracion()
                ,entidad.orElseThrow().getPorcentajeReal(),
                entidad.orElseThrow().getPorcentajeEsperado(),
                entidad.orElseThrow().getPorcentajeCumplimiento());
    }


}
