package com.ccoa.planeacionestrategica.dominio.modelo.usuario;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

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
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DEL_USUARIO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(apellido,LOS_APELLIDO_DEL_USUARIO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorCaracteresEspecialesPassword(password, LA_CONTRASENA_NO_CUENTA_CON_EL_PATRON_DE_SEGURIDAD_CORRRECTO);
        ValidadorDominio.validadorCaracteresEspecialesCorreo(correo,EL_CORREO_NO_CUENTA_CON_EL_FORMATO_CORRRECTO);
        ValidadorDominio.validadorNumeroLongYMayorACero(idCargo,NO_PUEDE_EXISTIR_SIN_CARGO);
        ValidadorDominio.validadorNoVacio(roles,EL_USUARIO_NO_PUEDE_EXISTIR_SIN_UN_ROL);
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
