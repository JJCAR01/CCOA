package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyecto;
import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador.MapeadorInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDetalleProyecto implements MapeadorInfraestructura<EntidadDetalleProyecto, DetalleProyecto> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa;
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica;

    public MapeadorDetalleProyecto(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa,
                                   RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa,
                                   RepositorioProyectoJpa repositorioProyectoJpa, RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa,
                                   RepositorioSprintJpa repositorioSprintJpa, MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioInformacionProyectoJpa = repositorioInformacionProyectoJpa;
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


    public void actualizarPorcentajeAvance(EntidadDetalleProyecto entidad) {
        /*List<EntidadSprint> sprints = this.repositorioSprintJpa.findByIdProyecto(entidad.getIdDetalleProyecto());
        long totalSprints = sprints.size();
        double sumaSprint = sprints.stream().mapToDouble(EntidadSprint::getAvance).sum();

        if (totalSprints > 0) {
            int nuevoAvance = (int) (sumaSprint / totalSprints);
            entidad.setAvance((double) nuevoAvance);
            mapeadorInformacionActividadEstrategica.actualizarPorcentajeAvance(obtenerProyectoRelacionado(entidad.getIdActividadEstrategica()));
        }*/
    }

    public EntidadInformacionActividadEstrategica obtenerProyectoRelacionado(Long id){
        return this.repositorioInformacionActividadEstrategicaJpa.findById(id).orElseThrow();
    }


}
