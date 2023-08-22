package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.Getter;

@Getter
public class Area {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;

    public static Area of(String nombre){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del Area NO puede estar vacío");
        return new Area(nombre);
    }

    public Area(String nombre) {
        this.nombre = nombre;
    }
}
