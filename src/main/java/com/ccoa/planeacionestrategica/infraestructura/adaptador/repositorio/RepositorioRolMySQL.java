package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.Rol;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRol;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioRolMySQL implements RepositorioRol {


    @Override
    public List<Rol> listar() {
        return null;
    }

    @Override
    public Rol consultarPorId(Long id) {
        return null;
    }

    @Override
    public Long guardar(Rol rol) {
        return null;
    }

    @Override
    public boolean existe(Rol rol) {
        return false;
    }

    @Override
    public Long eliminar(Long id) {
        return null;
    }

    @Override
    public Long modificar(Rol rol, Long id) {
        return null;
    }
}