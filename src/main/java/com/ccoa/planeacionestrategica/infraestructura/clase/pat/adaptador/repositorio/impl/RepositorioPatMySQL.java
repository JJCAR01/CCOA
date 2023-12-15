package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.mapeador.MapeadorInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.mapeador.MapeadorPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPatMySQL implements RepositorioPat {

    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;
    private final MapeadorPat mapeadorPat;
    private final MapeadorInformacionPat mapeadorInformacionPat;
    public RepositorioPatMySQL(RepositorioPatJpa repositorioPatJpa, RepositorioInformacionPatJpa repositorioInformacionPatJpa, MapeadorPat mapeadorPat, MapeadorInformacionPat mapeadorInformacionPat) {
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
        this.mapeadorPat = mapeadorPat;
        this.mapeadorInformacionPat = mapeadorInformacionPat;
    }

    @Override
    public List<DtoPatResumen> listar() {
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
    public Long guardar(Pat pat, InformacionPat informacionPat) {
        this.repositorioInformacionPatJpa.save(this.mapeadorInformacionPat.mapeadorEntidad(informacionPat));
        return this.repositorioPatJpa.save(mapeadorPat.mapeadorEntidad(pat)).getIdPat();
    }

    @Override
    public boolean existe(Pat pat) {
        return this.repositorioPatJpa.findByNombre(pat.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioPatJpa.deleteById(id);
        this.repositorioInformacionPatJpa.deleteById(id);
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
