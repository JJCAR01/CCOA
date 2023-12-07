package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.mapeador.MapeadorPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPatMySQL implements RepositorioPat {

    private final RepositorioPatJpa repositorioPatJpa;
    private final MapeadorPat mapeadorPat;
    public RepositorioPatMySQL(RepositorioPatJpa repositorioPatJpa, MapeadorPat mapeadorPat) {
        this.repositorioPatJpa = repositorioPatJpa;
        this.mapeadorPat = mapeadorPat;
    }

    @Override
    public List<Pat> listar() {
        var entidadPats =this.repositorioPatJpa.findAll();
        return this.mapeadorPat.listarDominio(entidadPats);
    }


    @Override
    public Pat consultarPorId(Long id) {
        var entidad = this.repositorioPatJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorPat.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Pat pat) {
        return this.repositorioPatJpa.save(mapeadorPat.mapeadorEntidad(pat)).getIdPat();
    }

    @Override
    public boolean existe(Pat pat) {
        return this.repositorioPatJpa.findByNombre(pat.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioPatJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Pat pat, Long id) {
        var entidad = this.repositorioPatJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorPat.actualizarEntidad(entidad, pat);
        return this.repositorioPatJpa.save(entidad).getIdPat();
    }

}
