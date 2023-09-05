package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class LineaEstrategica {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final String entregable;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final LocalDateTime fechaRegistro;
    private final String indicadorResultado;
    private final Long idPrograma;
    private final Long idUsuario;

    public static LineaEstrategica of(String nombre, String entregable, Date fechaInicio, Date fechaFinal, LocalDateTime fechaRegistro,
                                      String indicadorResultado, Long idPrograma, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,"El nombre de la Linea Estrategica NO debe estar vacío");
        ValidadorDominio.validarObligatorio(entregable,"El entregbable de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"La fecha inicial de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha final de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha registro de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validarObligatorio(indicadorResultado, "El indicador de resultado de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El usuario no puede estra vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idPrograma,"El programa NO debe de estar vacío");


        return new LineaEstrategica(nombre,entregable,fechaInicio,fechaFinal,fechaRegistro,indicadorResultado
                ,idUsuario,idPrograma);
    }

    public LineaEstrategica(String nombre, String entregable, Date fechaInicio, Date fechaFinal, LocalDateTime fechaRegistro, String indicadorResultado, Long idPrograma, Long idUsuario) {
        this.nombre = nombre;
        this.entregable = entregable;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.indicadorResultado = indicadorResultado;
        this.idPrograma = idPrograma;
        this.idUsuario = idUsuario;
    }
}
