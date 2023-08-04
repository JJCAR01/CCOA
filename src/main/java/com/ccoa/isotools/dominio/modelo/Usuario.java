package com.ccoa.isotools.dominio.modelo;

import com.ccoa.isotools.dominio.validador.ValidadorArgumento;
import com.ccoa.isotools.dominio.validador.ValidadorObjeto;
import com.ccoa.isotools.dominio.validador.ValidadorPatron;

import java.util.List;

public class Usuario {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombreUsuario;
    private final String nombre;
    private final String apellidos;
    private final String password;
    private final String correo;
    private final List<Rol> roles;
    private final Cargo cargo;

    public static Usuario of(String nombreUsuario,String nombre,String apellidos,String password,String correo,List<Rol> roles, Cargo cargo){
        ValidadorPatron.validadorNombreUsuario(nombreUsuario,"El nombre de usuario No cuenta con el patrón requerido");
        ValidadorArgumento.validarObligatorio(nombre,"El nombre del usuario NO puede ser vacío");
        ValidadorArgumento.validarObligatorio(apellidos,"Los apellidos del usuario NO puede ser vacío");
        ValidadorPatron.validadorCaracteresEspecialesPassword(password, "La contraseña NO cuenta con las ecritura correcta");
        ValidadorPatron.validadorCaracteresEspecialesCorreo(correo,"El correo NO cuenta con las ecritura correcta");
        ValidadorArgumento.validadorNoVacio(roles,"El usuario debe tener un rol");
        ValidadorObjeto.validarObjeto(cargo,"El usuario debe tener un cargo");
        return new Usuario(nombreUsuario,nombre,apellidos,password,correo,roles,cargo);
    }

    public Usuario(String nombreUsuario, String nombre, String apellidos, String password, String correo, List<Rol> roles, Cargo cargo) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.correo = correo;
        this.roles = roles;
        this.cargo = cargo;
    }
}
