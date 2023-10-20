package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.entidad.EntidadActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.mapeador.MapeadorActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.mapeador.MapeadorInformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.repositorio.jpa.RepositorioActividadGestionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionActividadEstrategicaJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioActividadGestionActividadEstrategicaMySQL implements RepositorioActividadGestionActividadEstrategica {

    private final RepositorioActividadGestionActividadEstrategicaJpa repositorioActividadGestionActividadEstrategicaJpa;
    private final RepositorioInformacionActividadGestionActividadEstrategicaJpa repositorioInformacionActividadGestionActividadEstrategicaJpa;

    public RepositorioActividadGestionActividadEstrategicaMySQL(RepositorioActividadGestionActividadEstrategicaJpa repositorioActividadGestionActividadEstrategicaJpa,
                                                                RepositorioInformacionActividadGestionActividadEstrategicaJpa repositorioInformacionActividadGestionActividadEstrategicaJpa) {
        this.repositorioActividadGestionActividadEstrategicaJpa = repositorioActividadGestionActividadEstrategicaJpa;
        this.repositorioInformacionActividadGestionActividadEstrategicaJpa = repositorioInformacionActividadGestionActividadEstrategicaJpa;
    }

    @Autowired
    private MapeadorActividadGestionActividadEstrategica mapeadorActividadGestionActividadEstrategica;
    @Autowired
    private MapeadorInformacionActividadGestionActividadEstrategica mapeadorInformacionActividadGestionActividadEstrategica;

    @Override
    public List<DtoActividadGestionActividadEstrategicaResumen> listar() {
        var entidad = this.repositorioActividadGestionActividadEstrategicaJpa.findAll();
        return this.mapeadorActividadGestionActividadEstrategica.listarDominio(entidad);
    }

    @Override
    public ActividadGestionActividadEstrategica consultarPorId(Long id) {
        var entidad = this.repositorioActividadGestionActividadEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorActividadGestionActividadEstrategica.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica, InformacionActividadGestionActividadEstrategica informacionActividadGestionActividadEstrategica) {
        var actividadEntidad = this.mapeadorActividadGestionActividadEstrategica.mapeadorEntidad(actividadGestionActividadEstrategica);
        var informacionActividadEntidad = this.mapeadorInformacionActividadGestionActividadEstrategica.mapeadorEntidad(informacionActividadGestionActividadEstrategica);
        this.repositorioInformacionActividadGestionActividadEstrategicaJpa.save(informacionActividadEntidad);
        return this.repositorioActividadGestionActividadEstrategicaJpa.save(actividadEntidad).getIdActividadGestionActividadEstrategica();
    }

    @Override
    public boolean existe(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica) {
        return this.repositorioActividadGestionActividadEstrategicaJpa.findByNombre(actividadGestionActividadEstrategica.getNombre())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioActividadGestionActividadEstrategicaJpa.deleteById(id);
        this.repositorioInformacionActividadGestionActividadEstrategicaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica, Long id) {
        return null;
    }

    @Override
    public List<DtoActividadGestionActividadEstrategicaResumen> consultarPorIdActividadEstrategica(Long idActividadEstrategica) {
        List<EntidadActividadGestionActividadEstrategica> entidades = this.repositorioActividadGestionActividadEstrategicaJpa.findByIdActividadEstrategica(idActividadEstrategica);
        return this.mapeadorActividadGestionActividadEstrategica.listarDominio(entidades);
    }

}
