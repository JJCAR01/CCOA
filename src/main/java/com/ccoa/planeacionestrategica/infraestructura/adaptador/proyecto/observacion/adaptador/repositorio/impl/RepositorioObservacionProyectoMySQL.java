package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.observacion.ObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioObservacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.adaptador.entidad.EntidadObservacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.adaptador.mapeador.MapeadorObservacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.adaptador.repositorio.jpa.RepositorioObservacionProyectoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioObservacionProyectoMySQL implements RepositorioObservacionProyecto {
    private final RepositorioObservacionProyectoJpa repositorioObservacionProyectoJpa;
    private final MapeadorObservacionProyecto mapeadorObservacionProyecto;

    public RepositorioObservacionProyectoMySQL(RepositorioObservacionProyectoJpa repositorioObservacionProyectoJpa,
                                               MapeadorObservacionProyecto mapeadorObservacionProyecto) {
        this.repositorioObservacionProyectoJpa = repositorioObservacionProyectoJpa;
        this.mapeadorObservacionProyecto = mapeadorObservacionProyecto;
    }
    @Override
    public List<DtoObservacionProyecto> listar() {
        var entidad = this.repositorioObservacionProyectoJpa.findAll();
        return this.mapeadorObservacionProyecto.listarDominio(entidad);
    }
    @Override
    public ObservacionProyecto consultarPorId(Long id) {
        var entidad = this.repositorioObservacionProyectoJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorObservacionProyecto.mapeadorDominio(entidad);
    }
    @Override
    public Long guardar(ObservacionProyecto observacionProyecto) {
        var observacionEntidad = this.mapeadorObservacionProyecto.mapeadorEntidad(observacionProyecto);
        return this.repositorioObservacionProyectoJpa.save(observacionEntidad).getIdObservacionProyecto();
    }
    @Override
    public boolean existe(ObservacionProyecto observacionProyecto) {
        return this.repositorioObservacionProyectoJpa.findById(observacionProyecto.getIdObservacionProyecto()).isPresent();
    }
    @Override
    public List<DtoObservacionProyecto> consultarPorIdProyecto(Long idProyecto) {
        List<EntidadObservacionProyecto> entidades = this.repositorioObservacionProyectoJpa.findByIdProyecto(idProyecto);
        return this.mapeadorObservacionProyecto.listarDominio(entidades);
    }

}
