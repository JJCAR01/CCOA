package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.Getter;

import java.util.Date;

@Getter
public class Pat {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final Date fechaRegistro;
    private final Long idUsuario;

    public static Pat of(String nombre,Date fechaInicio,Date fechaFinal,Date fechaRegistro,Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del PAT NO puede estar vacío");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"El dato fecha de inicio NO puede estar vacío");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"El dato fecha de final NO puede estar vacío");
        ValidadorDominio.validarObligatorioTipoDato(fechaRegistro,"La fecha de registro NO debe ser vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El usuario No puede ser vacío");
        return new Pat(nombre,fechaInicio,fechaFinal,fechaRegistro,idUsuario);
    }

    public Pat(String nombre, Date fechaInicio, Date fechaFinal, Date fechaRegistro, Long idUsuario) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
    }
}
