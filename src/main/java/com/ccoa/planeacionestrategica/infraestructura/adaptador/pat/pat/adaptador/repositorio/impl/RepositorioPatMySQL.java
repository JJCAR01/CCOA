package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.mapeador.MapeadorInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPatMySQL implements RepositorioPat {

    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;
    private final MapeadorPat mapeadorPat;
    private final MapeadorInformacionPat mapeadorInformacionPat;
    private final MapeadorInformacionUsuario mapeadorInformacionUsuario;
    private final RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa;
    public RepositorioPatMySQL(RepositorioPatJpa repositorioPatJpa, RepositorioInformacionPatJpa repositorioInformacionPatJpa, MapeadorPat mapeadorPat, MapeadorInformacionPat mapeadorInformacionPat, MapeadorInformacionUsuario mapeadorInformacionUsuario, RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa) {
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
        this.mapeadorPat = mapeadorPat;
        this.mapeadorInformacionPat = mapeadorInformacionPat;
        this.mapeadorInformacionUsuario = mapeadorInformacionUsuario;
        this.repositorioInformacionUsuarioJpa = repositorioInformacionUsuarioJpa;
    }

    @Override
    public List<DtoPatResumen> listar() {
        var entidadPats =this.repositorioPatJpa.findAll();
        return this.mapeadorPat.listarDominio(entidadPats);
    }

    @Override
    public DtoPatResumen consultarPorId(Long id) {
        var entidad = this.repositorioPatJpa.findById(id).orElse(null);
        var informacionPat = this.repositorioInformacionPatJpa.findById(id).orElse(null);
        assert entidad != null;
        assert informacionPat != null;
        return this.mapeadorPat.patDominio(entidad,informacionPat);
    }

    @Override
    public Long guardar(Pat pat, InformacionPat informacionPat) {
        var patEntity = mapeadorPat.mapeadorEntidad(pat);
        var idPat = this.repositorioPatJpa.save(patEntity).getIdPat();

        var informacionPatEntity = mapeadorInformacionPat.mapeadorEntidad(informacionPat);
        informacionPatEntity.setIdInformacionPat(idPat);
        this.repositorioInformacionPatJpa.save(informacionPatEntity);
        var entidadUsuario = mapeadorInformacionUsuario.obtenerUsuario(pat.getIdUsuario());
        mapeadorInformacionUsuario.actualizarPatsPorPat(entidadUsuario, pat);
        repositorioInformacionUsuarioJpa.save(entidadUsuario);
        return idPat;
    }
    @Override
    public boolean existe(Pat pat) {
        return this.repositorioPatJpa.findByNombre(pat.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioInformacionPatJpa.deleteById(id);
        this.repositorioPatJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Pat pat, InformacionPat informacionPat, Long id) {
        var entidadPat = this.repositorioPatJpa.findById(id).orElse(null);
        var entidadInformacionpat = this.repositorioInformacionPatJpa.findById(id).orElse(null);
        assert entidadPat != null;
        assert entidadInformacionpat != null;
        this.mapeadorPat.actualizarEntidad(entidadPat, pat);
        this.mapeadorInformacionPat.actualizarEntidad(entidadInformacionpat, informacionPat);
        this.repositorioInformacionPatJpa.save(entidadInformacionpat);
        return this.repositorioPatJpa.save(entidadPat).getIdPat();
    }

}
