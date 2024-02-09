package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador.MapeadorInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadInformacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioInformacionSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorDetalleProyecto implements MapeadorInfraestructura<EntidadDetalleProyecto, DetalleProyecto> {
    private final RepositorioInformacionActividadGestionEstrategicaJpa repositorioInformacionActividadGestionEstrategicaJpa;
    private final RepositorioInformacionSprintJpa repositorioInformacionSprintJpa;
    private final MapeadorProyecto mapeadorProyecto;
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica;

    public MapeadorDetalleProyecto(
            RepositorioInformacionActividadGestionEstrategicaJpa repositorioInformacionActividadGestionEstrategicaJpa,
            RepositorioInformacionSprintJpa repositorioInformacionSprintJpa,
            MapeadorProyecto mapeadorProyecto, RepositorioSprintJpa repositorioSprintJpa, MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica) {
        this.repositorioInformacionActividadGestionEstrategicaJpa = repositorioInformacionActividadGestionEstrategicaJpa;
        this.repositorioInformacionSprintJpa = repositorioInformacionSprintJpa;
        this.mapeadorProyecto = mapeadorProyecto;
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.mapeadorInformacionActividadEstrategica = mapeadorInformacionActividadEstrategica;
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
        List<EntidadInformacionSprint> informacionSprint = this.repositorioInformacionSprintJpa.
                findAll()
                .stream()
                .filter(e -> sprints.stream()
                        .anyMatch(sprint -> sprint.getIdSprint().equals(e.getIdInformacionSprint())))
                .toList();

        long totalSprints = sprints.size();
        double sumaSprint = informacionSprint.stream().mapToDouble(EntidadInformacionSprint::getPorcentajeReal).sum();

        if (totalSprints > 0) {
            int nuevoAvance = (int) (sumaSprint / totalSprints);
            entidad.setPorcentajeReal((double) nuevoAvance);
            var idActividadEstrategica = mapeadorProyecto.obtenerActividadEstrategicaRelacionadoConElProyecto(entidad.getIdDetalleProyecto()).getIdActividadEstrategica();
            var entidadActividad = mapeadorInformacionActividadEstrategica.obtenerTodaEntidadActividadEstrategica(idActividadEstrategica);
            mapeadorInformacionActividadEstrategica.actualizarPorcentajeAvance(entidadActividad,idActividadEstrategica);
        }
    }
    public EntidadDetalleProyecto obtenerTodaEntidadProyecto(Long idProyecto) {
        var entidad = repositorioInformacionActividadGestionEstrategicaJpa.findById(idProyecto);
        return new EntidadDetalleProyecto(entidad.orElseThrow().getDiasRestantes()
                ,entidad.orElseThrow().getPorcentajeReal(),
                entidad.orElseThrow().getPorcentajeEsperado(),
                entidad.orElseThrow().getPorcentajeCumplimiento());
    }


}
