package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorArgumento;
import com.ccoa.planeacionestrategica.dominio.validador.ValidadorNumero;
import lombok.Getter;

import java.util.List;

@Getter
public class TipoGI {

    //Clase de de asignacion de atributos y se validan entradas

    private final Integer cantidad;
    private final Double valorUnitario;
    private final Double valorTotal;
    private final String observacion;
    private final String clasificacion;

    public static TipoGI of(Integer cantidad,Double valorUnitario,Double valorTotal,String observacion,String clasificacion){
        ValidadorNumero.validadorNumeroEnteroMayorACero(cantidad,"La cantidad debe ser mayor a cero y no puede estar vacía");
        ValidadorNumero.validadorNumeroDoubleMayorACero(valorUnitario,"El valor unitario debe ser mayor a cero y no puede estar vacía");
        ValidadorNumero.validadorNumeroDoubleMayorACero(valorTotal,"El valor total debe ser mayor a cero y no puede estar vacía");
        ValidadorArgumento.validarObligatorio(clasificacion,"La clasificacion NO puede estar vacío");

        return new TipoGI(cantidad, valorUnitario, valorTotal, observacion,clasificacion);
    }

    public TipoGI(Integer cantidad, Double valorUnitario, Double valorTotal, String observacion, String clasificacion) {
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.observacion = observacion;
        this.clasificacion = clasificacion;
    }
}
