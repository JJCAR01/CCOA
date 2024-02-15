package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.observacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion.ObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioObservacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.observacion.adaptador.entidad.EntidadObservacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.observacion.adaptador.mapeador.MapeadorObservacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.observacion.adaptador.repositorio.jpa.RepositorioObservacionProyectoAreaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioObservacionProyectoAreaMySQL implements RepositorioObservacionProyectoArea {
    private final RepositorioObservacionProyectoAreaJpa repositorioObservacionProyectoAreaJpa;
    private final MapeadorObservacionProyectoArea mapeadorObservacionProyectoArea;

    public RepositorioObservacionProyectoAreaMySQL(RepositorioObservacionProyectoAreaJpa repositorioObservacionProyectoAreaJpa,
                                                       MapeadorObservacionProyectoArea mapeadorObservacionProyectoArea) {
        this.repositorioObservacionProyectoAreaJpa = repositorioObservacionProyectoAreaJpa;
        this.mapeadorObservacionProyectoArea = mapeadorObservacionProyectoArea;
    }
    @Override
    public List<DtoObservacionProyectoArea> listar() {
        var entidad = this.repositorioObservacionProyectoAreaJpa.findAll();
        return this.mapeadorObservacionProyectoArea.listarDominio(entidad);
    }
    @Override
    public ObservacionProyectoArea consultarPorId(Long id) {
        var entidad = this.repositorioObservacionProyectoAreaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorObservacionProyectoArea.mapeadorDominio(entidad);
    }
    @Override
    public Long guardar(ObservacionProyectoArea observacionProyectoArea) {
        var observacionEntidad = this.mapeadorObservacionProyectoArea.mapeadorEntidad(observacionProyectoArea);
        return this.repositorioObservacionProyectoAreaJpa.save(observacionEntidad).getIdObservacionProyectoArea();
    }
    @Override
    public boolean existe(ObservacionProyectoArea observacionProyectoArea) {
        return this.repositorioObservacionProyectoAreaJpa.findById(observacionProyectoArea.getIdObservacionProyectoArea()).isPresent();
    }
    @Override
    public List<DtoObservacionProyectoArea> consultarPorIdProyectoArea(Long idProyectoArea) {
        List<EntidadObservacionProyectoArea> entidades = this.repositorioObservacionProyectoAreaJpa.findByIdProyectoArea(idProyectoArea);
        return this.mapeadorObservacionProyectoArea.listarDominio(entidades);
    }

}
