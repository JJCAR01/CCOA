package com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.modelo.area.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.mapeador.MapeadorArea;
import com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.repositorio.jpa.RepositorioAreaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioAreaMySQL implements RepositorioArea{

    private final RepositorioAreaJpa repositorioAreaJpa;
    private final MapeadorArea mapeadorArea;

    public RepositorioAreaMySQL(RepositorioAreaJpa repositorioAreaJpa, MapeadorArea mapeadorArea) {
        this.repositorioAreaJpa = repositorioAreaJpa;
        this.mapeadorArea = mapeadorArea;
    }

    @Override
    public List<Area> listar() {
        var entidadArea =this.repositorioAreaJpa.findAll();
        return this.mapeadorArea.listarDominio(entidadArea);
    }

    @Override
    public Area consultarPorId(Long id) {
        var entidad = this.repositorioAreaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorArea.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Area area) {
        return this.repositorioAreaJpa.save(this.mapeadorArea.mapeadorEntidad(area)).getIdArea();
    }

    @Override
    public boolean existe(Area area) {
        return this.repositorioAreaJpa.findByNombre(area.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioAreaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Area area, Long id) {
        var entidad = this.repositorioAreaJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorArea.actualizarEntidad(entidad, area);
        return this.repositorioAreaJpa.save(entidad).getIdArea();
    }

}
