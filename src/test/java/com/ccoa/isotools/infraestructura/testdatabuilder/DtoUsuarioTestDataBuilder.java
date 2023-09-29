package com.ccoa.isotools.infraestructura.testdatabuilder;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;

import java.util.List;

public class DtoUsuarioTestDataBuilder {

    private long idUsuario;
    private String nombre;
    private String apellido;
    private String password;
    private String correo;
    private long idCargo;
    private List<Rol> roles;

    public DtoUsuarioTestDataBuilder() {
        this.idUsuario = 1;
        this.nombre = "Juan Jose";
        this.apellido = "cardona";
        this.password = "Colombia10+";
        this.correo = "juan@ccoa.org.co";
        this.idCargo = 1;
        this.roles = List.of(Rol.of(1L,"ADMIN"));
    }
    public DtoUsuarioTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }
    public DtoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public DtoUsuarioTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }
    public DtoUsuarioTestDataBuilder conPassword(String password) {
        this.password = password;
        return this;
    }
    public DtoUsuarioTestDataBuilder conCorreo(String correo) {
        this.correo = correo;
        return this;
    }
    public DtoUsuarioTestDataBuilder conIdCargo(Long idCargo) {
        this.idCargo = idCargo;
        return this;
    }
    public DtoUsuarioTestDataBuilder conRoles(List<Rol> roles) {
        this.roles = roles;
        return this;
    }

    public DtoUsuario build() {
        return new DtoUsuario(idUsuario,nombre,apellido,password,correo,idCargo,roles);
    }
}
