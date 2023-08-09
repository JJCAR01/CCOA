package com.ccoa.isotools.dominio.puerto;

import com.ccoa.isotools.dominio.modelo.TipoContrato;

import java.util.List;

public interface RepositorioTipoContrato {

    List<TipoContrato> listar();
    TipoContrato consultarPorId(Long id);
    Long guardar(TipoContrato tipoContrato);
    boolean existe(TipoContrato tipoContrato);
    Long eliminar(Long id);
    Long modificar(TipoContrato tipoContrato,Long id);
}
