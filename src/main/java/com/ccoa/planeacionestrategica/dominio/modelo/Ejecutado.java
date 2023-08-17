package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.Validador;
import lombok.Getter;

@Getter
public class Ejecutado {

    //Clase de de asignacion de atributos y se validan entradas

    private final Double valor;
    private final String tipoContrato;
    private final Integer numeroOrden;
    private final String documento;

    public static Ejecutado of(Double valor, String tipoContrato, Integer numeroOrden, String documento){
        Validador.validadorNumeroDoubleYMayorACero(valor,"El valor del ejecutado no puede ser vacío");
        Validador.validarObligatorio(tipoContrato,"El tipo contrato no debe ser vacío");
        Validador.validadorNumeroEnteroYMayorACero(numeroOrden,"El numero de orden no puede estar vacío");
        Validador.validarObligatorio(documento,"El documento NO puede estar vacío");

        return new Ejecutado(valor,tipoContrato, numeroOrden, documento);
    }

    public Ejecutado(Double valor, String tipoContrato, Integer numeroOrden, String documento) {
        this.valor = valor;
        this.tipoContrato = tipoContrato;
        this.numeroOrden = numeroOrden;
        this.documento = documento;
    }
}
