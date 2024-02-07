package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.observacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.observacion.ObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioObservacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.observacion.adaptador.entidad.EntidadObservacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.observacion.adaptador.mapeador.MapeadorObservacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.observacion.adaptador.repositorio.jpa.RepositorioObservacionActividadGestionJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioObservacionActividadGestionMySQL implements RepositorioObservacionActividadGestion {
    private final RepositorioObservacionActividadGestionJpa repositorioObservacionActividadGestionJpa;
    private final MapeadorObservacionActividadGestion mapeadorObservacionActividadGestion;

    public RepositorioObservacionActividadGestionMySQL(RepositorioObservacionActividadGestionJpa repositorioObservacionActividadGestionJpa,
                                                       MapeadorObservacionActividadGestion mapeadorObservacionActividadGestion) {
        this.repositorioObservacionActividadGestionJpa = repositorioObservacionActividadGestionJpa;
        this.mapeadorObservacionActividadGestion = mapeadorObservacionActividadGestion;
    }
    @Override
    public List<DtoObservacionActividadGestion> listar() {
        var entidad = this.repositorioObservacionActividadGestionJpa.findAll();
        return this.mapeadorObservacionActividadGestion.listarDominio(entidad);
    }
    @Override
    public ObservacionActividadGestion consultarPorId(Long id) {
        var entidad = this.repositorioObservacionActividadGestionJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorObservacionActividadGestion.mapeadorDominio(entidad);
    }
    @Override
    public Long guardar(ObservacionActividadGestion observacionActividadGestion) {
        var observacionEntidad = this.mapeadorObservacionActividadGestion.mapeadorEntidad(observacionActividadGestion);
        return this.repositorioObservacionActividadGestionJpa.save(observacionEntidad).getIdObservacionActividadGestion();
    }
    @Override
    public boolean existe(ObservacionActividadGestion observacionActividadGestion) {
        return this.repositorioObservacionActividadGestionJpa.findById(observacionActividadGestion.getIdObservacionActividadGestion()).isPresent();
    }
    @Override
    public List<DtoObservacionActividadGestion> consultarPorIdActividadGestion(Long idActividadGestion) {
        List<EntidadObservacionActividadGestion> entidades = this.repositorioObservacionActividadGestionJpa.findByIdActividadGestion(idActividadGestion);
        return this.mapeadorObservacionActividadGestion.listarDominio(entidades);
    }

}
