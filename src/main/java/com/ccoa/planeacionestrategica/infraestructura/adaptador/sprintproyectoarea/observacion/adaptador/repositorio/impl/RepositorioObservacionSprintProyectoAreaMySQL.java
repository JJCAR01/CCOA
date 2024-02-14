package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.observacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion.ObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion.ObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.observacion.adaptador.entidad.EntidadObservacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.observacion.adaptador.mapeador.MapeadorObservacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.observacion.adaptador.repositorio.jpa.RepositorioObservacionSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.observacion.adaptador.entidad.EntidadObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.observacion.adaptador.mapeador.MapeadorObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.observacion.adaptador.repositorio.jpa.RepositorioObservacionSprintProyectoAreaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioObservacionSprintProyectoAreaMySQL implements RepositorioObservacionSprintProyectoArea {
    private final RepositorioObservacionSprintProyectoAreaJpa repositorioObservacionSprintProyectoAreaJpa;
    private final MapeadorObservacionSprintProyectoArea mapeadorObservacionSprintProyectoArea;

    public RepositorioObservacionSprintProyectoAreaMySQL(RepositorioObservacionSprintProyectoAreaJpa repositorioObservacionSprintProyectoAreaJpa,
                                                                     MapeadorObservacionSprintProyectoArea mapeadorObservacionSprintProyectoArea) {
        this.repositorioObservacionSprintProyectoAreaJpa = repositorioObservacionSprintProyectoAreaJpa;
        this.mapeadorObservacionSprintProyectoArea = mapeadorObservacionSprintProyectoArea;
    }
    @Override
    public List<DtoObservacionSprintProyectoArea> listar() {
        var entidad = this.repositorioObservacionSprintProyectoAreaJpa.findAll();
        return this.mapeadorObservacionSprintProyectoArea.listarDominio(entidad);
    }
    @Override
    public ObservacionSprintProyectoArea consultarPorId(Long id) {
        var entidad = this.repositorioObservacionSprintProyectoAreaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorObservacionSprintProyectoArea.mapeadorDominio(entidad);
    }
    @Override
    public Long guardar(ObservacionSprintProyectoArea observacionSprintProyectoArea) {
        var observacionEntidad = this.mapeadorObservacionSprintProyectoArea.mapeadorEntidad(observacionSprintProyectoArea);
        return this.repositorioObservacionSprintProyectoAreaJpa.save(observacionEntidad).getIdObservacionSprintProyectoArea();
    }
    @Override
    public boolean existe(ObservacionSprintProyectoArea observacionSprintProyectoArea) {
        return this.repositorioObservacionSprintProyectoAreaJpa.findById(observacionSprintProyectoArea.getIdObservacionSprintProyectoArea()).isPresent();
    }
    @Override
    public List<DtoObservacionSprintProyectoArea> consultarPorIdSprintProyectoArea(Long idSprintProyectoArea) {
        List<EntidadObservacionSprintProyectoArea> entidades = this.repositorioObservacionSprintProyectoAreaJpa.findByIdSprintProyectoArea(idSprintProyectoArea);
        return this.mapeadorObservacionSprintProyectoArea.listarDominio(entidades);
    }

}
