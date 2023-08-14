package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoGI;

import java.util.List;

public interface RepositorioTipoGI {

    List<TipoGI> listar();
    TipoGI consultarPorId(Long id);
    Long guardar(TipoGI tipoGI);
    boolean existe(TipoGI tipoGI);
    Long eliminar(Long id);
    Long modificar(TipoGI tipoGI,Long id);
}


