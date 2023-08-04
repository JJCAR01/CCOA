package com.ccoa.isotools.dominio.modelo;

import com.ccoa.isotools.dominio.validador.ValidadorArgumento;
import com.ccoa.isotools.dominio.validador.ValidadorNumero;
import com.ccoa.isotools.dominio.validador.ValidadorObjeto;
import lombok.Getter;

import java.util.Date;

@Getter
public class ActividadPrincipal {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final String entregable;
    private final Double presupuesto;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final Date fechaRegistro;
    private final LineaEstrategica  lineaEstrategica;
    private final Usuario usuario;
    private final TipoActividad tipoActividad;
    private final TipoGI tipoGI;

    public static ActividadPrincipal of(String nombre, String entregable, Double presupuesto,Date fechaInicio,
                                        Date fechaFinal, Date fechaRegistro, LineaEstrategica lineaEstrategica,
                                        Usuario usuario, TipoActividad tipoActividad, TipoGI tipoGI){
        ValidadorArgumento.validarObligatorio(nombre,"El nombre de la actividad principal NO debe estar vacía");
        ValidadorArgumento.validarObligatorio(entregable,"El entregable  de la actividad principal NO debe estar vacía");
        ValidadorNumero.validadorNumeroDoubleMayorACero(presupuesto,"El presupesto de la actividad principal NO debe estar vacía");
        ValidadorArgumento.validarObligatorioTipoDate(fechaInicio,"La fecha inicio de la actividad principal NO debe estar vacía");
        ValidadorArgumento.validarObligatorioTipoDate(fechaFinal,"La fecha inicial de la actividad principal NO debe estar vacía");
        ValidadorArgumento.validarObligatorioTipoDate(fechaRegistro,"La fecha de resgistro de la actividad principal NO debe estar vacía");
        ValidadorObjeto.validarObjeto(lineaEstrategica,"La linea estrategica NO debe estar vacía");
        ValidadorObjeto.validarObjeto(usuario,"El usuario NO debe estar vacía");
        ValidadorObjeto.validarObjeto(tipoActividad,"El tipo de actividad NO debe estar vacía");
        ValidadorObjeto.validarObjeto(tipoGI,"El tipo GI NO debe estar vacía");

        return new ActividadPrincipal(nombre, entregable, presupuesto, fechaInicio, fechaFinal, fechaRegistro,
                lineaEstrategica, usuario, tipoActividad, tipoGI);
    }

    public ActividadPrincipal(String nombre, String entregable, Double presupuesto, Date fechaInicio, Date fechaFinal,
                              Date fechaRegistro, LineaEstrategica lineaEstrategica, Usuario usuario,
                              TipoActividad tipoActividad, TipoGI tipoGI) {
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
