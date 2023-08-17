package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.Validador;
import lombok.Getter;

import java.util.Date;

@Getter
public class ActividadPrincipal {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final String tipoActividad;
    private final String entregable;
    private final Double presupuesto;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final Date fechaRegistro;
    private final LineaEstrategica  lineaEstrategica;
    private final Usuario usuario;
    private final TipoGI tipoGI;

    public static ActividadPrincipal of(String nombre,String tipoActividad, String entregable, Double presupuesto,Date fechaInicio,
                                        Date fechaFinal, Date fechaRegistro, LineaEstrategica lineaEstrategica,
                                        Usuario usuario, TipoGI tipoGI){
        Validador.validarObligatorio(nombre,"El nombre de la actividad principal NO debe estar vacía");
        Validador.validarObligatorio(tipoActividad,"El tipo de actividad NO debe estar vacío");
        Validador.validarObligatorio(entregable,"El entregable  de la actividad principal NO debe estar vacía");
        Validador.validadorNumeroDoubleYMayorACero(presupuesto,"El presupesto de la actividad principal NO debe estar vacía");
        Validador.validarObligatorioTipoDato(fechaInicio,"La fecha inicio de la actividad principal NO debe estar vacía");
        Validador.validarObligatorioTipoDato(fechaFinal,"La fecha inicial de la actividad principal NO debe estar vacía");
        Validador.validarObligatorioTipoDato(fechaRegistro,"La fecha de resgistro de la actividad principal NO debe estar vacía");
        Validador.validarObjeto(lineaEstrategica,"La linea estrategica NO debe estar vacía");
        Validador.validarObjeto(usuario,"El usuario NO debe estar vacía");
        Validador.validarObjeto(tipoGI,"El tipo GI NO debe estar vacía");

        return new ActividadPrincipal(nombre, entregable, presupuesto, fechaInicio, fechaFinal, fechaRegistro,
                lineaEstrategica, usuario, tipoActividad, tipoGI);
    }

    public ActividadPrincipal(String nombre, String entregable, Double presupuesto, Date fechaInicio, Date fechaFinal,
                              Date fechaRegistro, LineaEstrategica lineaEstrategica, Usuario usuario,
                              String tipoActividad, TipoGI tipoGI) {
        this.nombre = nombre;
        this.entregable = entregable;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.lineaEstrategica = lineaEstrategica;
        this.usuario = usuario;
        this.tipoActividad = tipoActividad;
        this.tipoGI = tipoGI;
    }
}
