package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.Pat;

import java.util.List;

public interface RepositorioPat {


    List<Pat> listar();
    Pat consultarPorId(Long id);
    Long guardar(Pat pat );
    boolean existe(Pat pat);
    Long eliminar(Long id);
    Long modificar(Pat pat ,Long id);

}


