package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombreUsuario;
    private final String nombre;
    private final String apellido;
    private final String password;
    private final String correo;
    private final Long idCargo;
    private final Long idRol;

    public static Usuario of(String nombreUsuario,String nombre,String apellido,String password,String correo,Long idCargo, Long idRol){
        ValidadorDominio.validadorNombreUsuario(nombreUsuario,"El nombre de usuario No cuenta con el patrón requerido");
        ValidadorDominio.validarObligatorio(nombre,"El nombre del usuario NO puede ser vacío");
        ValidadorDominio.validarObligatorio(apellido,"Los apellidos del usuario NO puede ser vacío");
        ValidadorDominio.validadorCaracteresEspecialesPassword(password, "La contraseña NO cuenta con las ecritura correcta");
        ValidadorDominio.validadorCaracteresEspecialesCorreo(correo,"El correo NO cuenta con las ecritura correcta");
        ValidadorDominio.validadorNumeroLongYMayorACero(idCargo,"El usuario debe tener un rol");
        ValidadorDominio.validadorNumeroLongYMayorACero(idRol,"El usuario debe tener un id cargo");
        return new Usuario(nombreUsuario,nombre,apellido,password,correo,idCargo,idRol);
    }

    public Usuario(String nombreUsuario, String nombre, String apellido, String password, String correo, Long idCargo, Long idRol) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.correo = correo;
        this.idCargo = idCargo;
        this.idRol = idRol;
    }
}
