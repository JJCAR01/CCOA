package com.ccoa.isotools.dominio.modelo;

import com.ccoa.isotools.dominio.validador.ValidadorArgumento;
import lombok.Getter;


@Getter
public class RubroGasto {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;

    public static RubroGasto of(String nombre){
        ValidadorArgumento.validarObligatorio(nombre,"El nombre del rubro de gasto NO puede estar vacío");
        return new RubroGasto(nombre);
    }

    public RubroGasto(String nombre) {
        this.nombre = nombre;
    }
}
