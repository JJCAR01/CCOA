package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.Validador;
import lombok.Getter;

import java.util.Date;

@Getter
public class LineaEstrategica {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final String entregable;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final Date fechaRegistro;
    private final String indicardorResultado;
    private final Programa programa;
    private final Usuario usuario;

    public static LineaEstrategica of(String nombre,String entregable, Date fechaInicio,Date fechaFinal,
                                      Date fechaRegistro,String indicardorResultado,Programa programa, Usuario usuario){
        Validador.validarObligatorio(nombre,"El nombre de la Linea Estrategica NO debe estar vacío");
        Validador.validarObligatorio(entregable,"El entregbable de la linea estatregica NO debe estar vacía");
        Validador.validarObligatorioTipoDato(fechaInicio,"La fecha inicial de la linea estatregica NO debe estar vacía");
        Validador.validarObligatorioTipoDato(fechaFinal,"La fecha final de la linea estatregica NO debe estar vacía");
        Validador.validarObligatorioTipoDato(fechaRegistro,"La fecha registro de la linea estatregica NO debe estar vacía");
        Validador.validarObligatorio(indicardorResultado, "El indicador de resultado de la linea estatregica NO debe estar vacía");
        Validador.validarObjeto(programa,"El programa NO debe de estar vacío");
        Validador.validarObjeto(usuario,"El usuario no puede estra vacío");

        return new LineaEstrategica(nombre,entregable,fechaInicio,fechaFinal,fechaRegistro,indicardorResultado,
                programa,usuario);
    }

    public LineaEstrategica(String nombre, String entregable, Date fechaInicio, Date fechaFinal, Date fechaRegistro, String indicardorResultado, Programa programa, Usuario usuario) {
        this.nombre = nombre;
        this.entregable = entregable;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.indicardorResultado = indicardorResultado;
        this.programa = programa;
        this.usuario = usuario;
    }
}
