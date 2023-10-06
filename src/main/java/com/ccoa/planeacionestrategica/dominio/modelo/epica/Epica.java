package com.ccoa.planeacionestrategica.dominio.modelo.epica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Epica {

    //Clase de de asignacion de atributos y se validan entradas

    private final Long idEpica;
    private final String nombre;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;
    private final Long idUsuario;
    private final Long idPat;



    public static Epica of(Long idEpica, String nombre, LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario, Long idPat){
        ValidadorDominio.validarObligatorio(nombre,"El Nombre de la Epica NO puede estar vacía");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicial,"La fecha de inicio del epica NO debe estar vacía");
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicial,"La fecha inicial no puede ser mayor a la fecha final");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha final del epica NO debe estar vacía");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha de registro del epica NO debe estar vacía");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El Usuario NO puede estar vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idPat,"El Pat NO puede estar vacío");

        return new Epica(idEpica, nombre,fechaInicial,fechaFinal,fechaRegistro,idUsuario,idPat);
    }


    public Epica(Long idEpica, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario, Long idPat) {
        this.idEpica = idEpica;
        this.nombre = nombre;
        this.fechaInicial = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
        this.idPat = idPat;
    }
}
