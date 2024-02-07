package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.observacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion.ObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica.RepositorioObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.observacion.adaptador.entidad.EntidadObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.observacion.adaptador.mapeador.MapeadorObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.observacion.adaptador.repositorio.jpa.RepositorioObservacionActividadEstrategicaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioObservacionActividadEstrategicaMySQL implements RepositorioObservacionActividadEstrategica {
    private final RepositorioObservacionActividadEstrategicaJpa repositorioObservacionActividadEstrategicaJpa;
    private final MapeadorObservacionActividadEstrategica mapeadorObservacionActividadEstrategica;

    public RepositorioObservacionActividadEstrategicaMySQL(RepositorioObservacionActividadEstrategicaJpa repositorioObservacionActividadEstrategicaJpa,
                                                           MapeadorObservacionActividadEstrategica mapeadorObservacionActividadEstrategica) {
        this.repositorioObservacionActividadEstrategicaJpa = repositorioObservacionActividadEstrategicaJpa;
        this.mapeadorObservacionActividadEstrategica = mapeadorObservacionActividadEstrategica;
    }
    @Override
    public List<DtoObservacionActividadEstrategica> listar() {
        var entidad = this.repositorioObservacionActividadEstrategicaJpa.findAll();
        return this.mapeadorObservacionActividadEstrategica.listarDominio(entidad);
    }
    @Override
    public ObservacionActividadEstrategica consultarPorId(Long id) {
        var entidad = this.repositorioObservacionActividadEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorObservacionActividadEstrategica.mapeadorDominio(entidad);
    }
    @Override
    public Long guardar(ObservacionActividadEstrategica observacionActividadEstrategica) {
        var observacionEntidad = this.mapeadorObservacionActividadEstrategica.mapeadorEntidad(observacionActividadEstrategica);
        return this.repositorioObservacionActividadEstrategicaJpa.save(observacionEntidad).getIdObservacionActividadEstrategica();
    }
    @Override
    public boolean existe(ObservacionActividadEstrategica observacionActividadEstrategica) {
        return this.repositorioObservacionActividadEstrategicaJpa.findById(observacionActividadEstrategica.getIdObservacionActividadEstrategica()).isPresent();
    }
    @Override
    public List<DtoObservacionActividadEstrategica> consultarPorIdActividadEstrategica(Long idActividadEstrategica) {
        List<EntidadObservacionActividadEstrategica> entidades = this.repositorioObservacionActividadEstrategicaJpa.findByIdActividadEstrategica(idActividadEstrategica);
        return this.mapeadorObservacionActividadEstrategica.listarDominio(entidades);
    }

}
