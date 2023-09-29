package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;

public class AreaTestDataBuilder {

    private Long idArea;
    private String nombre;

    public AreaTestDataBuilder() {
        this.idArea = 1L;
        this.nombre = "TI";
    }

    public AreaTestDataBuilder conIdArea(Long idArea) {
        this.idArea = idArea;
        return this;
    }

    public AreaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Area build() {
        return Area.of(idArea,nombre);
    }


}
