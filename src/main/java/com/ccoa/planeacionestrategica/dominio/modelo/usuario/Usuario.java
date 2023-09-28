package com.ccoa.planeacionestrategica.dominio.modelo.usuario;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Usuario {

    //Clase de de asignacion de atributos y se validan entradas

    private final Long idUsuario;
    private final String nombre;
    private final String apellido;
    private final String password;
    private final String correo;
    private final Long idCargo;
    private final List<Rol> roles;

    public static Usuario of(Long idUsuario,String nombre,String apellido,String password,String correo,Long idCargo, List<Rol> roles){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del usuario NO puede ser vacío");
        ValidadorDominio.validarObligatorio(apellido,"Los apellidos del usuario NO puede ser vacío");
        ValidadorDominio.validadorCaracteresEspecialesPassword(password, "La contraseña NO cuenta con las ecritura correcta");
        ValidadorDominio.validadorCaracteresEspecialesCorreo(correo,"El correo NO cuenta con las ecritura correcta");
        ValidadorDominio.validadorNumeroLongYMayorACero(idCargo,"El usuario debe tener un cargo");
        ValidadorDominio.validadorNoVacio(roles,"El usuario debe tener rol");
        return new Usuario(idUsuario, nombre,apellido,password,correo,idCargo,roles);
    }

    public Usuario(Long idUsuario, String nombre, String apellido, String password, String correo, Long idCargo, List<Rol> roles) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.correo = correo;
        this.idCargo = idCargo;
        this.roles = roles;
    }
}