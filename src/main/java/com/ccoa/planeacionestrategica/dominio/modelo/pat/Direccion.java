package com.ccoa.planeacionestrategica.dominio.modelo.pat;

import lombok.Getter;

@Getter
public class Direccion {

    private final String nombre;

    public Direccion(String nombre) {
        this.nombre = nombre;
    }
}
