package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;

import java.util.List;

public interface RepositorioRubroIngreso {

    List<RubroIngreso> listar();
    RubroIngreso consultarPorId(Long id);
    Long guardar(RubroIngreso rubroIngreso );
    boolean existe(RubroIngreso rubroIngreso);
    Long eliminar(Long id);
    Long modificar(RubroIngreso rubroIngreso ,Long id);
}
