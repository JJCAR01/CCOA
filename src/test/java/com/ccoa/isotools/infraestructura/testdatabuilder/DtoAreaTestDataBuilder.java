package com.ccoa.isotools.infraestructura.testdatabuilder;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;

public class DtoAreaTestDataBuilder {

    private long idArea;
    private String nombre;

    public DtoAreaTestDataBuilder() {
        this.idArea = 1;
        this.nombre = "TI";
    }

    public DtoAreaTestDataBuilder conIdArea(Long idArea) {
        this.idArea = idArea;
        return this;
    }
    public DtoAreaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DtoArea build() {
        return new DtoArea(idArea, nombre);
    }


}
