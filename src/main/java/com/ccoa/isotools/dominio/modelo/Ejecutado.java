package com.ccoa.isotools.dominio.modelo;

import com.ccoa.isotools.dominio.validador.ValidadorNumero;
import lombok.Getter;

import java.io.File;

@Getter
public class Ejecutado {

    //Clase de de asignacion de atributos y se validan entradas

    private final Double valor;
    private final Integer numeroOrden;
    private final File documento;

    public static Ejecutado of(Double valor,Integer numeroOrden,File documento){
        ValidadorNumero.validadorNumeroDoubleMayorACero(valor,"El valor del ejecutado no puede ser vacío");
        ValidadorNumero.validadorNumeroEnteroMayorACero(numeroOrden,"El numero de orden no puede estar vacío");

        return new Ejecutado(valor, numeroOrden, documento);
    }

    public Ejecutado(Double valor, Integer numeroOrden, File documento) {
        this.valor = valor;
        this.numeroOrden = numeroOrden;
        this.documento = documento;
    }
}
