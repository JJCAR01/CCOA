package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;

import java.util.List;

public interface RepositorioCargo {

    List<Cargo> listar();
    Cargo consultarPorId(Long id);
    Long guardar(Cargo cargo);
    boolean existe(Cargo cargo);
    Long eliminar(Long id);
    Long modificar(Cargo cargo,Long id);
}
