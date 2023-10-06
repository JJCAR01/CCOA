package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;

import java.util.List;

public class UsuarioTestDataBuilder {

    private final long idUsuario;
    private final String nombre;
    private final String apellido;
    private final String password;
    private final String correo;
    private final long idCargo;
    private final List<Rol> roles;

    public UsuarioTestDataBuilder() {
        this.idUsuario = 1;
        this.nombre = "Juan Jose";
        this.apellido = "cardona";
        this.password = "Colombia2020+";
        this.correo = "juancardona@ccoa.org.co";
        this.idCargo = 1;
        this.roles = List.of(Rol.of(1L,"ADMIN"));
    }

    public Usuario build() {
        return Usuario.of(idUsuario,nombre,apellido,password,correo,idCargo,roles);
    }

}
