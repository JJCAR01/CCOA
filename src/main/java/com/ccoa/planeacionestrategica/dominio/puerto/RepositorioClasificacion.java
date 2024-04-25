package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoClasificacionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.clasificacion.Clasificacion;

import java.util.List;

public interface RepositorioClasificacion {

    List<DtoClasificacionResumen> listar();
    DtoClasificacionResumen consultarPorId(Long id);
    Long guardar(Clasificacion clasificacion);
    boolean existe(Clasificacion clasificacion);
    Long eliminar(Long id);
    Long modificar(Clasificacion clasificacion,Long id);
}
