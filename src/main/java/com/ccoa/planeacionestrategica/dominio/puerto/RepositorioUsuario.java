package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;

import java.util.List;

public interface RepositorioUsuario {

    List<Usuario> listar();
    Usuario consultarPorId(Long id);
    Long guardar(Usuario usuario);
    boolean existe(Usuario usuario);
    Long eliminar(Long id);
    Long modificar(Usuario usuario,Long id);
}
