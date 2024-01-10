package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;

import java.util.List;

public interface RepositorioDireccion {

    List<Direccion> listar();
    Direccion consultarPorId(Long id);
    Long guardar(Direccion direccion);
    boolean existe(Direccion direccion);
    Long eliminar(Long id);
    Long modificar(Direccion direccion,Long id);
}
