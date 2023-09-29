package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;

import java.util.List;

public class UsuarioTestDataBuilder {

    private long idUsuario;
    private  String nombre;
    private  String apellido;
    private  String password;
    private  String correo;
    private  long idCargo;
    private  List<Rol> roles;

    public UsuarioTestDataBuilder() {
        this.idUsuario = 1;
        this.nombre = "Juan Jose";
        this.apellido = "cardona";
        this.password = "Colombia2020+";
        this.correo = "juancardona@ccoa.org.co";
        this.idCargo = 1;
        this.roles = List.of(Rol.of(1l,"ADMIN"));
    }

    public UsuarioTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public UsuarioTestDataBuilder conPassword(String password) {
        this.password = password;
        return this;
    }

    public UsuarioTestDataBuilder conCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public UsuarioTestDataBuilder conIdCargo(Long idCargo) {
        this.idCargo = idCargo;
        return this;
    }

    public UsuarioTestDataBuilder conIdRol(List<Rol> roles) {
        this.roles = roles;
        return this;
    }

    public Usuario build() {
        return Usuario.of(idUsuario,nombre,apellido,password,correo,idCargo,roles);
    }

}
