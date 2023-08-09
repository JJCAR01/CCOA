package com.ccoa.isotools.dominio.puerto;

import com.ccoa.isotools.dominio.dto.DtoCargoResumen;
import com.ccoa.isotools.dominio.modelo.Area;

import java.util.List;

public interface RepositorioArea {

    List<Area> listar();
    Area consultarPorId(Long id);
    Long guardar(Area area);
    boolean existe(Area area);
    Long eliminar(Long id);
    Long modificar(Area area,Long id);

}
