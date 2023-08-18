package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;

import java.util.List;

public interface RepositorioUsuario {

    List<DtoUsuarioResumen> listar();
    DtoUsuarioResumen consultarPorId(Long id);
    Long guardar(Usuario usuario);
    boolean existe(Usuario usuario);
    Long eliminar(Long id);
    Usuario consultar(String nombreUsuario, String password);
    Long modificar(Usuario usuario,Long id);
}
