package com.ccoa.planeacionestrategica.dominio.modelo.direccion;

import lombok.Getter;

@Getter
public class Direccion {

    private final String nombre;

    public static Direccion of(String nombre){
        return new Direccion(nombre);
    }

    public Direccion( String nombre) {
        this.nombre = nombre;
    }
}
