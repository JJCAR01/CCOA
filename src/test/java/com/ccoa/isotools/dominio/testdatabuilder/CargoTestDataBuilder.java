package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;

public class CargoTestDataBuilder {

    private String nombre;
    private long idArea;

    public CargoTestDataBuilder() {
        this.nombre = "Tec 1";
        this.idArea = 1;
    }

    public CargoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CargoTestDataBuilder conIdArea(Long idArea) {
        this.idArea = idArea;
        return this;
    }

    public Cargo build() {
        return Cargo.of(nombre,idArea);
    }

}
