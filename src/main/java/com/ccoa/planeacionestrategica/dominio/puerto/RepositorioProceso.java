package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProcesoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;

import java.util.List;

public interface RepositorioProceso {

    List<DtoProcesoResumen> listar();
    DtoProcesoResumen consultarPorId(Long id);
    Long guardar(Proceso proceso);
    boolean existe(Proceso proceso);
    Long eliminar(Long id);
    Long modificar(Proceso proceso,Long id);
}
