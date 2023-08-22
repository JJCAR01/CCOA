package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Rol;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRol;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadRol;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioRolJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioRolMySQL implements RepositorioRol {

    private final RepositorioRolJpa repositorioRolJpa;

    public RepositorioRolMySQL(RepositorioRolJpa repositorioRolJpa) {
        this.repositorioRolJpa = repositorioRolJpa;
    }

    @Override
    public List<Rol> listar() {
        List<EntidadRol> entidadRols =this.repositorioRolJpa.findAll();
        return entidadRols.stream().map(entidadRol -> Rol.of(entidadRol.getRol())).toList();
    }

    @Override
    public Rol consultarPorId(Long id) {
        return this.repositorioRolJpa.findById(id).map(entidadRol -> Rol.of(entidadRol.getRol())).orElse(null);
    }

    @Override
    public Long guardar(Rol rol) {
        EntidadRol entidadRol = new EntidadRol(rol.getRol());
        return this.repositorioRolJpa.save(entidadRol).getId_rol();
    }

    @Override
    public boolean existe(Rol rol) {
        return this.repositorioRolJpa.findByRol(rol.getRol()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioRolJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Rol rol, Long id) {
        repositorioRolJpa.findById(id);
        EntidadRol entidadRol = new EntidadRol();
        entidadRol.setId_rol(id);
        entidadRol.setRol(rol.getRol());
        repositorioRolJpa.save(entidadRol);
        return id;
    }

}