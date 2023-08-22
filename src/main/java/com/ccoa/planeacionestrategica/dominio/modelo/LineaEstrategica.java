package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
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
    private final Long idPrograma;
    private final Long idUsuario;

    public static LineaEstrategica of(String nombre, String entregable, Date fechaInicio, Date fechaFinal, Date fechaRegistro,
                                      String indicardorResultado, Long idPrograma, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,"El nombre de la Linea Estrategica NO debe estar vacío");
        ValidadorDominio.validarObligatorio(entregable,"El entregbable de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"La fecha inicial de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha final de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validarObligatorioTipoDato(fechaRegistro,"La fecha registro de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validarObligatorio(indicardorResultado, "El indicador de resultado de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validadorNumeroLongYMayorACero(idPrograma,"El programa NO debe de estar vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El usuario no puede estra vacío");

        return new LineaEstrategica(nombre,entregable,fechaInicio,fechaFinal,fechaRegistro,indicardorResultado,
                idPrograma,idUsuario);
    }

    public LineaEstrategica(String nombre, String entregable, Date fechaInicio, Date fechaFinal, Date fechaRegistro, String indicardorResultado, Long idPrograma, Long idUsuario) {
        this.nombre = nombre;
        this.entregable = entregable;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.indicardorResultado = indicardorResultado;
        this.idPrograma = idPrograma;
        this.idUsuario = idUsuario;
    }
}
