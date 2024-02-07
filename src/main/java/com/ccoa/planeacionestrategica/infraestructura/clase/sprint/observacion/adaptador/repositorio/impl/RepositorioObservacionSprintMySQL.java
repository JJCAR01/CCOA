package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.observacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.ObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioObservacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.observacion.adaptador.entidad.EntidadObservacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.observacion.adaptador.mapeador.MapeadorObservacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.observacion.adaptador.repositorio.jpa.RepositorioObservacionSprintJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioObservacionSprintMySQL implements RepositorioObservacionSprint {
    private final RepositorioObservacionSprintJpa repositorioObservacionSprintJpa;
    private final MapeadorObservacionSprint mapeadorObservacionSprint;

    public RepositorioObservacionSprintMySQL(RepositorioObservacionSprintJpa repositorioObservacionSprintJpa,
                                             MapeadorObservacionSprint mapeadorObservacionSprint) {
        this.repositorioObservacionSprintJpa = repositorioObservacionSprintJpa;
        this.mapeadorObservacionSprint = mapeadorObservacionSprint;
    }
    @Override
    public List<DtoObservacionSprint> listar() {
        var entidad = this.repositorioObservacionSprintJpa.findAll();
        return this.mapeadorObservacionSprint.listarDominio(entidad);
    }
    @Override
    public ObservacionSprint consultarPorId(Long id) {
        var entidad = this.repositorioObservacionSprintJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorObservacionSprint.mapeadorDominio(entidad);
    }
    @Override
    public Long guardar(ObservacionSprint observacionSprint) {
        var observacionEntidad = this.mapeadorObservacionSprint.mapeadorEntidad(observacionSprint);
        return this.repositorioObservacionSprintJpa.save(observacionEntidad).getIdObservacionSprint();
    }
    @Override
    public boolean existe(ObservacionSprint observacionSprint) {
        return this.repositorioObservacionSprintJpa.findById(observacionSprint.getIdObservacionSprint()).isPresent();
    }
    @Override
    public List<DtoObservacionSprint> consultarPorIdSprint(Long idSprint) {
        List<EntidadObservacionSprint> entidades = this.repositorioObservacionSprintJpa.findByIdSprint(idSprint);
        return this.mapeadorObservacionSprint.listarDominio(entidades);
    }

}
