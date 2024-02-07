package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.observacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.observacion.ObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.observacion.adaptador.entidad.EntidadObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.observacion.adaptador.mapeador.MapeadorObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.observacion.adaptador.repositorio.jpa.RepositorioObservacionActividadGestionActividadEstrategicaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioObservacionGestionEstrategicaMySQL implements RepositorioObservacionActividadGestionEstrategica {
    private final RepositorioObservacionActividadGestionActividadEstrategicaJpa repositorioObservacionActividadGestionEstrategicaJpa;
    private final MapeadorObservacionActividadGestionEstrategica mapeadorObservacionActividadGestionEstrategica;

    public RepositorioObservacionGestionEstrategicaMySQL(RepositorioObservacionActividadGestionActividadEstrategicaJpa repositorioObservacionActividadGestionEstrategicaJpa,
                                                         MapeadorObservacionActividadGestionEstrategica mapeadorObservacionActividadGestionEstrategica) {
        this.repositorioObservacionActividadGestionEstrategicaJpa = repositorioObservacionActividadGestionEstrategicaJpa;
        this.mapeadorObservacionActividadGestionEstrategica = mapeadorObservacionActividadGestionEstrategica;
    }

    @Override
    public List<DtoObservacionActividadGestionEstrategica> listar() {
        var entidad = this.repositorioObservacionActividadGestionEstrategicaJpa.findAll();
        return this.mapeadorObservacionActividadGestionEstrategica.listarDominio(entidad);
    }
    @Override
    public ObservacionActividadGestionEstrategica consultarPorId(Long id) {
        var entidad = this.repositorioObservacionActividadGestionEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorObservacionActividadGestionEstrategica.mapeadorDominio(entidad);
    }
    @Override
    public Long guardar(ObservacionActividadGestionEstrategica observacionActividadGestionEstrategica) {
        var observacionEntidad = this.mapeadorObservacionActividadGestionEstrategica.mapeadorEntidad(observacionActividadGestionEstrategica);
        return this.repositorioObservacionActividadGestionEstrategicaJpa.save(observacionEntidad).getIdObservacionActividadGestionEstrategica();
    }
    @Override
    public boolean existe(ObservacionActividadGestionEstrategica observacionActividadGestionEstrategica) {
        return this.repositorioObservacionActividadGestionEstrategicaJpa.findById(observacionActividadGestionEstrategica.getIdActividadGestionEstrategica()).isPresent();
    }

    @Override
    public List<DtoObservacionActividadGestionEstrategica> consultarPorIdActividadGestionEstrategica(Long idActividadGestionEstrategica) {
        List<EntidadObservacionActividadGestionEstrategica> entidades = this.repositorioObservacionActividadGestionEstrategicaJpa.findByIdActividadGestionEstrategica(idActividadGestionEstrategica);
        return this.mapeadorObservacionActividadGestionEstrategica.listarDominio(entidades);
    }

}
