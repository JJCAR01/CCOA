package com.ccoa.planeacionestrategica.dominio.modelo.proceso;

import lombok.Getter;

@Getter
public class Proceso {

    private final String nombre;

    public static Proceso of(String nombre){
        return new Proceso(nombre);
    }
    public Proceso(String nombre) {
        this.nombre = nombre;
    }
}
