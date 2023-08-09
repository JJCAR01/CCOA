package com.ccoa.isotools.infraestructura.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;

public class DtoAreaTestDataBuilder {

    private String nombre;

    public DtoAreaTestDataBuilder() {
        this.nombre = "nombre";
    }

    public DtoAreaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Area build() {return Area.of(nombre);}
}
