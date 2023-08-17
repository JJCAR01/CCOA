package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorArgumento;
import com.ccoa.planeacionestrategica.dominio.validador.ValidadorNumero;
import com.ccoa.planeacionestrategica.dominio.validador.ValidadorObjeto;
import com.ccoa.planeacionestrategica.dominio.validador.ValidadorPatron;
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
    private final List<Rol> roles;
    private final Long idCargo;

    public static Usuario of(String nombreUsuario,String nombre,String apellidos,String password,String correo,List<Rol> roles, Long idCargo){
        ValidadorPatron.validadorNombreUsuario(nombreUsuario,"El nombre de usuario No cuenta con el patrón requerido");
        ValidadorArgumento.validarObligatorio(nombre,"El nombre del usuario NO puede ser vacío");
        ValidadorArgumento.validarObligatorio(apellidos,"Los apellidos del usuario NO puede ser vacío");
        ValidadorPatron.validadorCaracteresEspecialesPassword(password, "La contraseña NO cuenta con las ecritura correcta");
        ValidadorPatron.validadorCaracteresEspecialesCorreo(correo,"El correo NO cuenta con las ecritura correcta");
        ValidadorArgumento.validadorNoVacio(roles,"El usuario debe tener un rol");
        ValidadorNumero.validadorNumeroLongYMayorACero(idCargo,"El usuario debe tener un id cargo");
        return new Usuario(nombreUsuario,nombre,apellidos,password,correo,roles,idCargo);
    }

    public Usuario(String nombreUsuario, String nombre, String apellidos, String password, String correo, List<Rol> roles, Long idCargo) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.correo = correo;
        this.roles = roles;
        this.idCargo = idCargo;
    }
}
