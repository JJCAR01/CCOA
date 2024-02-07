package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.observacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.ObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioObservacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.observacion.adaptador.entidad.EntidadObservacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.observacion.adaptador.mapeador.MapeadorObservacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.observacion.adaptador.repositorio.jpa.RepositorioObservacionTareaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioObservacionTareaMySQL implements RepositorioObservacionTarea {
    private final RepositorioObservacionTareaJpa repositorioObservacionTareaJpa;
    private final MapeadorObservacionTarea mapeadorObservacionTarea;

    public RepositorioObservacionTareaMySQL(RepositorioObservacionTareaJpa repositorioObservacionTareaJpa, MapeadorObservacionTarea mapeadorObservacionTarea) {
        this.repositorioObservacionTareaJpa = repositorioObservacionTareaJpa;
        this.mapeadorObservacionTarea = mapeadorObservacionTarea;
    }

    @Override
    public List<DtoObservacionTarea> listar() {
        var entidad = this.repositorioObservacionTareaJpa.findAll();
        return this.mapeadorObservacionTarea.listarDominio(entidad);
    }

    @Override
    public ObservacionTarea consultarPorId(Long id) {
        var entidad = this.repositorioObservacionTareaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorObservacionTarea.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(ObservacionTarea observacionTarea) {
        var observacionEntidad = this.mapeadorObservacionTarea.mapeadorEntidad(observacionTarea);
        return this.repositorioObservacionTareaJpa.save(observacionEntidad).getIdObservacionTarea();
    }

    @Override
    public boolean existe(ObservacionTarea observacionTarea) {
        return this.repositorioObservacionTareaJpa.findById(observacionTarea.getIdObservacionTarea()).isPresent();
    }

    @Override
    public List<DtoObservacionTarea> consultarPorIdTarea(Long idTarea) {
        List<EntidadObservacionTarea> entidades = this.repositorioObservacionTareaJpa.findByIdTarea(idTarea);
        return this.mapeadorObservacionTarea.listarDominio(entidades);
    }
}
