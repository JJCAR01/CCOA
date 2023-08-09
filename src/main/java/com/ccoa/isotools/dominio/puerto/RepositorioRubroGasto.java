package com.ccoa.isotools.dominio.puerto;

import com.ccoa.isotools.dominio.modelo.RubroGasto;

import java.util.List;

public interface RepositorioRubroGasto {

    List<RubroGasto> listar();
    RubroGasto consultarPorId(Long id);
    Long guardar(RubroGasto rubroGasto);
    //boolean existe(RubroGasto rubroGasto);
    Long eliminar(Long id);
    Long modificar(RubroGasto rubroGasto,Long id);
}
