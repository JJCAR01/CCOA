package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ActividadEstrategica {

    //Clase de de asignacion de atributos y se validan entradas

    private final Long idActividadEstrategica;
    private final String nombre;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;



    public static ActividadEstrategica of(Long idActividadEstrategica, String nombre, LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaRegistro){
        ValidadorDominio.validarObligatorio(nombre,"El Nombre de la Epica NO puede estar vacía");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicial,"La fecha de inicio del epica NO debe estar vacía");
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicial,"La fecha inicial no puede ser mayor a la fecha final");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha final del epica NO debe estar vacía");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha de registro del epica NO debe estar vacía");

        return new ActividadEstrategica(idActividadEstrategica, nombre,fechaInicial,fechaFinal,fechaRegistro);
    }


    public ActividadEstrategica(Long idActividadEstrategica, String nombre, LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaRegistro) {
        this.idActividadEstrategica = idActividadEstrategica;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;


    }
}
