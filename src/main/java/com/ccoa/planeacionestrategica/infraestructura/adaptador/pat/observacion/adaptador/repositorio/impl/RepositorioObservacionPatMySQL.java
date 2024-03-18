package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.observacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoObservacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.observacion.ObservacionPat;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioObservacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.observacion.adaptador.repositorio.jpa.RepositorioObservacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.observacion.adaptador.entidad.EntidadObservacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.observacion.adaptador.mapeador.MapeadorObservacionPat;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioObservacionPatMySQL implements RepositorioObservacionPat {
    private final RepositorioObservacionPatJpa repositorioObservacionPatJpa;
    private final MapeadorObservacionPat mapeadorObservacionPat;

    public RepositorioObservacionPatMySQL(RepositorioObservacionPatJpa repositorioObservacionPatJpa,
                                          MapeadorObservacionPat mapeadorObservacionPat) {
        this.repositorioObservacionPatJpa = repositorioObservacionPatJpa;
        this.mapeadorObservacionPat = mapeadorObservacionPat;
    }
    @Override
    public List<DtoObservacionPat> listar() {
        var entidad = this.repositorioObservacionPatJpa.findAll();
        return this.mapeadorObservacionPat.listarDominio(entidad);
    }
    @Override
    public ObservacionPat consultarPorId(Long id) {
        var entidad = this.repositorioObservacionPatJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorObservacionPat.mapeadorDominio(entidad);
    }
    @Override
    public Long guardar(ObservacionPat observacionPat) {
        var observacionEntidad = this.mapeadorObservacionPat.mapeadorEntidad(observacionPat);
        return this.repositorioObservacionPatJpa.save(observacionEntidad).getIdObservacionPat();
    }
    @Override
    public boolean existe(ObservacionPat observacionPat) {
        return this.repositorioObservacionPatJpa.findById(observacionPat.getIdObservacionPat()).isPresent();
    }
    @Override
    public List<DtoObservacionPat> consultarPorIdPat(Long idPat) {
        List<EntidadObservacionPat> entidades = this.repositorioObservacionPatJpa.findByIdPat(idPat);
        return this.mapeadorObservacionPat.listarDominio(entidades);
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioObservacionPatJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(ObservacionPat observacionPat, Long id) {
        var entidad = this.repositorioObservacionPatJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorObservacionPat.actualizarEntidad(entidad, observacionPat);
        return this.repositorioObservacionPatJpa.save(entidad).getIdObservacionPat();
    }

}
