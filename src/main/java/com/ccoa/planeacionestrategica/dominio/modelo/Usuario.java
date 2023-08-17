package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Usuario {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombreUsuario;
    private final String nombre;
    private final String apellidos;
    private final String password;
    private final String correo;
    private final Long idRol;
    private final Long idCargo;

    public static Usuario of(String nombreUsuario,String nombre,String apellidos,String password,String correo,Long idRol, Long idCargo){
        Validador.validadorNombreUsuario(nombreUsuario,"El nombre de usuario No cuenta con el patrón requerido");
        Validador.validarObligatorio(nombre,"El nombre del usuario NO puede ser vacío");
        Validador.validarObligatorio(apellidos,"Los apellidos del usuario NO puede ser vacío");
        Validador.validadorCaracteresEspecialesPassword(password, "La contraseña NO cuenta con las ecritura correcta");
        Validador.validadorCaracteresEspecialesCorreo(correo,"El correo NO cuenta con las ecritura correcta");
        Validador.validadorNumeroLongYMayorACero(idRol,"El usuario debe tener un rol");
        Validador.validadorNumeroLongYMayorACero(idCargo,"El usuario debe tener un id cargo");
        return new Usuario(nombreUsuario,nombre,apellidos,password,correo,idRol,idCargo);
    }

    public Usuario(String nombreUsuario, String nombre, String apellidos, String password, String correo, Long idRol, Long idCargo) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.correo = correo;
        this.idRol = idRol;
        this.idCargo = idCargo;
    }
}
