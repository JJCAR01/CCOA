package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioAreaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class    RepositorioAreaMySQL implements RepositorioArea{

    private final RepositorioAreaJpa repositorioAreaJpa;

    public RepositorioAreaMySQL(RepositorioAreaJpa repositorioAreaJpa) {
        this.repositorioAreaJpa = repositorioAreaJpa;
    }

    @Override
    public List<Area> listar() {
        List<EntidadArea> entidadAreas =this.repositorioAreaJpa.findAll();
        return entidadAreas.stream().map(entidadArea -> Area.of(entidadArea.getNombre())).toList();
    }

    @Override
    public Area consultarPorId(Long id) {
        return this.repositorioAreaJpa.findById(id).map(entidadArea -> Area.of(entidadArea.getNombre())).orElse(null);
    }

    @Override
    public Long guardar(Area area) {
        EntidadArea entidadArea = new EntidadArea(area.getNombre());
        return this.repositorioAreaJpa.save(entidadArea).getId();
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
        repositorioAreaJpa.findById(id);
        EntidadArea entidadArea = new EntidadArea();
        entidadArea.setId(id);
        entidadArea.setNombre(area.getNombre());
        repositorioAreaJpa.save(entidadArea);
        return id;
    }

}
