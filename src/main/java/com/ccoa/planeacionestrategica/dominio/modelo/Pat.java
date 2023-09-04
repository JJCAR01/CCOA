package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
public class Pat {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final LocalDateTime fechaRegistro;
    private final Double porcentajeReal;
    private final Double porcentajeEsperado;
    private final Double cumplimiento;
    private final Long idUsuario;

    public static Pat of(String nombre,Date fechaInicio,Date fechaFinal,LocalDateTime fechaRegistro,
                         Double porcentajeReal,Double porcentajeEsperado,Double cumplimiento, Long idUsuario ){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del PAT NO puede estar vacío");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"El dato fecha de inicio NO puede estar vacío");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"El dato fecha de final NO puede estar vacío");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha de registro NO debe ser vacío");
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeReal,"Porcentaje real null o es menor a 0");
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeEsperado,"Porcentaje esperado null o es menor a 0");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El usuario No puede ser vacío");
        return new Pat(nombre,fechaInicio,fechaFinal,fechaRegistro,porcentajeReal,porcentajeEsperado,cumplimiento,idUsuario);
    }

    public Pat(String nombre, Date fechaInicio, Date fechaFinal, LocalDateTime fechaRegistro,Double porcentajeReal,
               Double porcentajeEsperado,Double cumplimiento,Long idUsuario ) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.cumplimiento = cumplimiento;
        this.idUsuario = idUsuario;
    }
}
