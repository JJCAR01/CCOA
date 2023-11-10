package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.mapeador.MapeadorActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.mapeador.MapeadorInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioActividadEstrategicaMySQL implements RepositorioActividadEstrategica {
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final MapeadorActividadEstrategica mapeadorActividadEstrategica;
    private final MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica;

    public RepositorioActividadEstrategicaMySQL(RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa, RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa,
                                                MapeadorActividadEstrategica mapeadorActividadEstrategica, MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica) {
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.mapeadorActividadEstrategica = mapeadorActividadEstrategica;
        this.mapeadorInformacionActividadEstrategica = mapeadorInformacionActividadEstrategica;
    }

    @Override
    public List<DtoActividadEstrategicaResumen> listar() {
        var entidad = this.repositorioActividadEstrategicaJpa.findAll();
        return this.mapeadorActividadEstrategica.listarDominio(entidad);
    }


    @Override
    public DtoActividadEstrategicaResumen consultarPorId(Long id) {
        var entidad = this.repositorioActividadEstrategicaJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionActividadEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        return this.mapeadorActividadEstrategica.listarDominioPorId(entidad,entidadInf);
    }

    @Override
    public Long guardar(ActividadEstrategica actividadEstrategica, InformacionActividadEstrategica informacionActividadEstrategica) {
        var epicaEntidad = this.mapeadorActividadEstrategica.mapeadorEntidad(actividadEstrategica);
        var informacionGestionEntidad = this.mapeadorInformacionActividadEstrategica.mapeadorEntidad(informacionActividadEstrategica);
        this.repositorioInformacionActividadEstrategicaJpa.save(informacionGestionEntidad);
        return this.repositorioActividadEstrategicaJpa.save(epicaEntidad).getIdActividadEstrategica();
    }

    @Override
    public boolean existe(ActividadEstrategica actividadEstrategica) {
        return this.repositorioActividadEstrategicaJpa.findByNombre(actividadEstrategica.getNombre())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioInformacionActividadEstrategicaJpa.deleteById(id);
        this.repositorioActividadEstrategicaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(ActividadEstrategica actividadEstrategica,InformacionActividadEstrategica informacionActividadEstrategica, Long id) {
        var entidad = this.repositorioActividadEstrategicaJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionActividadEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        this.mapeadorActividadEstrategica.actualizarEntidad(entidad, actividadEstrategica,entidadInf,informacionActividadEstrategica);
        this.repositorioInformacionActividadEstrategicaJpa.save(entidadInf);
        return this.repositorioActividadEstrategicaJpa.save(entidad).getIdActividadEstrategica();
    }

    @Override
    public List<DtoActividadEstrategicaResumen> consultarPorIdPat(Long idPat) {
        List<EntidadInformacionActividadEstrategica> entidades = this.repositorioInformacionActividadEstrategicaJpa.findByIdPat(idPat);
        return this.mapeadorInformacionActividadEstrategica.listaDominioPorPat(entidades);
    }
}
