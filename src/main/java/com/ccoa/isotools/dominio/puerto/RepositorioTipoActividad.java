package com.ccoa.isotools.dominio.puerto;

import com.ccoa.isotools.dominio.modelo.TipoActividad;

import java.util.List;

public interface RepositorioTipoActividad {

    List<TipoActividad> listar();
    TipoActividad consultarPorId(Long id);
    Long guardar(TipoActividad tipoActividad);
    boolean existe(TipoActividad tipoActividad);
    Long eliminar(Long id);
    Long modificar(TipoActividad tipoActividad,Long id);
}
