package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.Ejecutado;

import java.util.List;

public interface RepositorioEjecutado {

    List<Ejecutado> listar();
    Ejecutado consultarPorId(Long id);
    Long guardar(Ejecutado ejecutado );
    boolean existe(Ejecutado ejecutado );
    Long eliminar(Long id);
    Long modificar(Ejecutado ejecutado ,Long id);
}
