package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.ActividadPrincipal;

import java.util.List;

public interface RepositorioActividadPrincipal {

    List<ActividadPrincipal> listar();
    ActividadPrincipal consultarPorId(Long id);
    Long guardar(ActividadPrincipal actividadPrincipal );
    boolean existe(ActividadPrincipal actividadPrincipal );
    Long eliminar(Long id);
    Long modificar(ActividadPrincipal actividadPrincipal,Long id);
}
