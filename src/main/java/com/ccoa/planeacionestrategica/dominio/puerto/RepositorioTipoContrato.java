package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;

import java.util.List;

public interface RepositorioTipoContrato {

    List<TipoContrato> listar();
    TipoContrato consultarPorId(Long id);
    Long guardar(TipoContrato tipoContrato);
    boolean existe(TipoContrato tipoContrato);
    Long eliminar(Long id);
    Long modificar(TipoContrato tipoContrato,Long id);
}
