package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;

public class AreaTestDataBuilder {

    private String nombre;

    public AreaTestDataBuilder() {
        this.nombre = "nombre";
    }

    public AreaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Area build() {return Area.of(nombre);}
}
