package com.ccoa.planeacionestrategica.dominio.modelo.programa;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class Programa {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final String codigo;
    private final Integer version;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final LocalDateTime fechaRegistro;

    public static Programa of(String nombre, String codigo, Integer version, Date fechaInicio, Date fechaFinal, LocalDateTime fechaRegistro){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del programa NO debe estar vacío");
        ValidadorDominio.validarObligatorio(codigo,"El codigo NO debe estar vacío");
        ValidadorDominio.validadorNumeroEnteroYMayorACero(version,"La version del programa debe ser mayor a cero y NO puede estar vacío");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"La fecha de inicio del programa NO debe estar vacía");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha final del programa NO debe estar vacía");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha de registro del programa NO debe estar vacía");

        return new Programa(nombre,codigo,version,fechaInicio,fechaFinal,fechaRegistro);
    }

    public Programa(String nombre, String codigo, Integer version, Date fechaInicio, Date fechaFinal, LocalDateTime fechaRegistro) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.version = version;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
    }
}
