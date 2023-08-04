package com.ccoa.isotools.dominio.modelo;

import com.ccoa.isotools.dominio.validador.ValidadorArgumento;
import lombok.Getter;

@Getter
public class TipoContrato {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;

    public static TipoContrato of(String nombre){
        ValidadorArgumento.validarObligatorio(nombre,"El nombre del tipo de contrato NO debe ser vacío");
        return new TipoContrato(nombre);
    }

    public TipoContrato(String nombre) {
        this.nombre = nombre;
    }
}
