package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;

import java.util.List;

public interface RepositorioGestion {

    List<Gestion> listar();
    Gestion consultarPorId(Long id);
    List<Gestion> consultarPorIdPat(Long idPat);
    Long guardar(Gestion gestion);
    boolean existe(Gestion gestion);
    Long eliminar(Long id);
    Long modificar(Gestion gestion, Long id);
}


