package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorArgumento;
import com.ccoa.planeacionestrategica.dominio.validador.ValidadorObjeto;
import lombok.Getter;

import java.util.Date;

@Getter
public class Pat {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final Date fechaRegistro;
    private final Usuario usuario;

    public static Pat of(String nombre,Date fechaInicio,Date fechaFinal,Date fechaRegistro,Usuario usuario){
        ValidadorArgumento.validarObligatorio(nombre,"El nombre del PAT NO puede estar vacío");
        ValidadorArgumento.validarObligatorioTipoDato(fechaInicio,"El dato fecha de inicio NO puede estar vacío");
        ValidadorArgumento.validarObligatorioTipoDato(fechaFinal,"El dato fecha de final NO puede estar vacío");
        ValidadorArgumento.validarObligatorioTipoDato(fechaRegistro,"La fecha de registro NO debe ser vacío");
        ValidadorObjeto.validarObjeto(usuario,"El usuario No puede ser vacío");
        return new Pat(nombre,fechaInicio,fechaFinal,fechaRegistro,usuario);
    }

    public Pat(String nombre, Date fechaInicio, Date fechaFinal, Date fechaRegistro, Usuario usuario) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.usuario = usuario;
    }
}
