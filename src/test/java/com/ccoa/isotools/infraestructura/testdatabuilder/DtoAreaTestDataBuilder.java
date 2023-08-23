package com.ccoa.isotools.infraestructura.testdatabuilder;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;

public class DtoAreaTestDataBuilder {

    private String nombre;

    public DtoAreaTestDataBuilder() {
        this.nombre = "TI";
    }
    public DtoAreaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DtoArea build() {
        return new DtoArea(nombre);
    }


}
