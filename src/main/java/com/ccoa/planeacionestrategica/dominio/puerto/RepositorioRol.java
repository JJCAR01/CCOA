package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Rol;

import java.util.List;

public interface RepositorioRol {

    List<Rol> listar();
    Rol consultarPorId(Long id);
    Long guardar(Rol rol);
    boolean existe(Rol rol);
    Long eliminar(Long id);
    Long modificar(Rol rol,Long id);
}
