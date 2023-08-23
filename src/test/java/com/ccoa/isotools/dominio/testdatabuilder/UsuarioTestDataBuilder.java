package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;

public class UsuarioTestDataBuilder {

    private  String nombreUsuario;
    private  String nombre;
    private  String apellido;
    private  String password;
    private  String correo;
    private  long idCargo;
    private  long idRol;

    public UsuarioTestDataBuilder() {
        this.nombreUsuario = "j.cardona";
        this.nombre = "Juan Jose";
        this.apellido = "cardona";
        this.password = "Colombia22+";
        this.correo = "juan@gmail.com";
        this.idCargo = 1;
        this.idRol = 1;

    }

    public UsuarioTestDataBuilder conNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

    public UsuarioTestDataBuilder conIdRol(Long idRol) {
        this.idRol = idRol;
        return this;
    }

    public Usuario build() {
        return Usuario.of(nombreUsuario,nombre,apellido,password,correo,idCargo,idRol);
    }
}
