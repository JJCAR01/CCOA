package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;

import java.util.List;

public interface RepositorioUsuario {

    List<DtoUsuarioResumen> listar();
    Usuario consultarPorId(Long id);
    Long guardar(Usuario usuario, Rol rol, InformacionUsuario informacionUsuario);
    boolean existe(Usuario usuario);
    Long eliminar(Long id);
    Usuario consultar(String correo, String password);
    Long modificar(Usuario usuario,InformacionUsuario informacionUsuario,Long id);
    String obtenerDireccionDelUsuario(String correo);
    String obtenerProcesoDelUsuario(String correo);
}
