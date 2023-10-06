package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;

public class AreaTestDataBuilder {

    private final Long idArea;
    private final String nombre;

    public AreaTestDataBuilder() {
        this.idArea = 1L;
        this.nombre = "TI";
    }

    public Area build() {
        return Area.of(idArea,nombre);
    }


}
