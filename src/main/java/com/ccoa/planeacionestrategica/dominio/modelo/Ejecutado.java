package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.Getter;

@Getter
public class Ejecutado {

    //Clase de de asignacion de atributos y se validan entradas

    private final Double valor;
    private final String tipoContrato;
    private final Integer numeroOrden;
    private final String documento;
    private final Long idUsuario;
    private final Long idActividadPrincipal;

    public static Ejecutado of(Double valor, String tipoContrato, Integer numeroOrden, String documento, Long idUsuario, Long idActividadPrincipal) {
        ValidadorDominio.validadorNumeroDoubleYMayorACero(valor,"El valor del ejecutado no puede ser vacío");
        ValidadorDominio.validarObligatorio(tipoContrato,"El tipo contrato no debe ser vacío");
        ValidadorDominio.validadorNumeroEnteroYMayorACero(numeroOrden,"El numero de orden no puede estar vacío");
        ValidadorDominio.validarObligatorio(documento,"El documento NO puede estar vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El Id del Usuario no esta correcto");
        ValidadorDominio.validadorNumeroLongYMayorACero(idActividadPrincipal,"El Id de la actividad principal no esta correcto");
        return new Ejecutado(valor,tipoContrato, numeroOrden, documento,idUsuario,idActividadPrincipal);
    }

    public Ejecutado(Double valor, String tipoContrato, Integer numeroOrden, String documento, Long idUsuario, Long idActividadPrincipal) {
        this.valor = valor;
        this.tipoContrato = tipoContrato;
        this.numeroOrden = numeroOrden;
        this.documento = documento;
        this.idUsuario = idUsuario;
        this.idActividadPrincipal = idActividadPrincipal;
    }
}
