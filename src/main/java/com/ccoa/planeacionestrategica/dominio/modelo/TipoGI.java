package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

@Getter
public class TipoGI {

    //Clase de de asignacion de atributos y se validan entradas

    private final Long idTipoGI;
    private final Integer cantidad;
    private final String clasificacion;
    private final Double valorUnitario;
    private final Double valorTotal;
    private final String observacion;


    public static TipoGI of(Long idTipoGI,Integer cantidad,String clasificacion,Double valorUnitario,Double valorTotal,String observacion){
        ValidadorDominio.validadorNumeroEnteroYMayorACero(cantidad,"La cantidad debe ser mayor a cero y no puede estar vacía");
        ValidadorDominio.validadorNumeroDoubleYMayorACero(valorUnitario,"El valor unitario debe ser mayor a cero y no puede estar vacía");
        ValidadorDominio.validadorNumeroDoubleYMayorACero(valorTotal,"El valor total debe ser mayor a cero y no puede estar vacía");
        ValidadorDominio.validarObligatorio(clasificacion,"La clasificacion NO puede estar vacío");
        return new TipoGI(idTipoGI, cantidad,clasificacion, valorUnitario, valorTotal, observacion);
    }

    public TipoGI(Long idTipoGI, Integer cantidad, String clasificacion, Double valorUnitario, Double valorTotal, String observacion) {
        this.idTipoGI = idTipoGI;
        this.cantidad = cantidad;
        this.clasificacion = clasificacion;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.observacion = observacion;
    }
}
