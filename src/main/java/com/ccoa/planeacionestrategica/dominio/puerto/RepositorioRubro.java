package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;

import java.util.List;

public interface RepositorioRubro {

    List<Rubro> listar();
    Rubro consultarPorId(Long id);
    Long guardar(Rubro rubro);
    boolean existe(Rubro rubro);
    Long eliminar(Long id);
    Long modificar(Rubro rubro, Long id);
}
