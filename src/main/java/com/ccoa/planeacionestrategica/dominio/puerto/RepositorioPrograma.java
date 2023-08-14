package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.Programa;

import java.util.List;

public interface RepositorioPrograma {

    List<Programa> listar();
    Programa consultarPorId(Long id);
    Long guardar(Programa programa);
    boolean existe(Programa programa);
    Long eliminar(Long id);
    Long modificar(Programa programa,Long id);

}