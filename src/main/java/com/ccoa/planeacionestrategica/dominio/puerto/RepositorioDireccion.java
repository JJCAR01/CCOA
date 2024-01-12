package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoDireccionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;

import java.util.List;

public interface RepositorioDireccion {

    List<DtoDireccionResumen> listar();
    DtoDireccionResumen consultarPorId(Long id);
    Long guardar(Direccion direccion);
    boolean existe(Direccion direccion);
    Long eliminar(Long id);
    Long modificar(Direccion direccion,Long id);
}
