package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.LineaEstrategica;

import java.util.List;

public interface RepositorioLineaEstrategica {

    List<LineaEstrategica> listar();
    LineaEstrategica consultarPorId(Long id);
    Long guardar(LineaEstrategica lineaEstrategica );
    boolean existe(LineaEstrategica lineaEstrategica );
    Long eliminar(Long id);
    Long modificar(LineaEstrategica lineaEstrategica ,Long id);
}


