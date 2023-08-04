package com.ccoa.isotools.dominio.modelo;

import com.ccoa.isotools.dominio.validador.ValidadorArgumento;
import lombok.Getter;

@Getter
public class Area {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;

    public static Area of(String nombre){
        ValidadorArgumento.validarObligatorio(nombre,"El nobre NO puede estar vacío");
        return new Area(nombre);
    }

    public Area(String nombre) {
        this.nombre = nombre;
    }
}
