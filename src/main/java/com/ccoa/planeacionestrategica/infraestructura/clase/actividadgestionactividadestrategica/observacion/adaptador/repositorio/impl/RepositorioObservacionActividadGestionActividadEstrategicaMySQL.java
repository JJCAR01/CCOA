package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.observacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.observacion.ObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionactividadestrategica.RepositorioObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.observacion.adaptador.entidad.EntidadObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.observacion.adaptador.mapeador.MapeadorObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.observacion.adaptador.repositorio.jpa.RepositorioObservacionActividadGestionActividadEstrategicaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioObservacionActividadGestionActividadEstrategicaMySQL implements RepositorioObservacionActividadGestionActividadEstrategica {
    private final RepositorioObservacionActividadGestionActividadEstrategicaJpa repositorioObservacionActividadGestionActividadEstrategicaJpa;
    private final MapeadorObservacionActividadGestionActividadEstrategica mapeadorObservacionActividadGestionActividadEstrategica;

    public RepositorioObservacionActividadGestionActividadEstrategicaMySQL(RepositorioObservacionActividadGestionActividadEstrategicaJpa repositorioObservacionActividadGestionActividadEstrategicaJpa,
                                                                           MapeadorObservacionActividadGestionActividadEstrategica mapeadorObservacionActividadGestionActividadEstrategica) {
        this.repositorioObservacionActividadGestionActividadEstrategicaJpa = repositorioObservacionActividadGestionActividadEstrategicaJpa;
        this.mapeadorObservacionActividadGestionActividadEstrategica = mapeadorObservacionActividadGestionActividadEstrategica;
    }
    @Override
    public List<DtoObservacionActividadGestionActividadEstrategica> listar() {
        var entidad = this.repositorioObservacionActividadGestionActividadEstrategicaJpa.findAll();
        return this.mapeadorObservacionActividadGestionActividadEstrategica.listarDominio(entidad);
    }
    @Override
    public ObservacionActividadGestionActividadEstrategica consultarPorId(Long id) {
        var entidad = this.repositorioObservacionActividadGestionActividadEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorObservacionActividadGestionActividadEstrategica.mapeadorDominio(entidad);
    }
    @Override
    public Long guardar(ObservacionActividadGestionActividadEstrategica observacionActividadGestionActividadEstrategica) {
        var observacionEntidad = this.mapeadorObservacionActividadGestionActividadEstrategica.mapeadorEntidad(observacionActividadGestionActividadEstrategica);
        return this.repositorioObservacionActividadGestionActividadEstrategicaJpa.save(observacionEntidad).getIdObservacionActividadGestionActividadEstrategica();
    }
    @Override
    public boolean existe(ObservacionActividadGestionActividadEstrategica observacionActividadGestionActividadEstrategica) {
        return this.repositorioObservacionActividadGestionActividadEstrategicaJpa.findById(observacionActividadGestionActividadEstrategica.getIdObservacionActividadGestionActividadEstrategica()).isPresent();
    }
    @Override
    public List<DtoObservacionActividadGestionActividadEstrategica> consultarPorIdActividadGestionActividadEstrategica(Long idActividadGestionActividadEstrategica) {
        List<EntidadObservacionActividadGestionActividadEstrategica> entidades = this.repositorioObservacionActividadGestionActividadEstrategicaJpa.findByIdActividadGestionActividadEstrategica(idActividadGestionActividadEstrategica);
        return this.mapeadorObservacionActividadGestionActividadEstrategica.listarDominio(entidades);
    }

}
