package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.RegistroActividad;

import java.util.List;

public interface RepositorioRegistroActividad {

    List<RegistroActividad> listar();
    RegistroActividad consultarPorId(Long id);
    Long guardar(RegistroActividad registroActividad);
    boolean existe(RegistroActividad registroActividad);
    Long eliminar(Long id);
    Long modificar(RegistroActividad registroActividad,Long id);
}
