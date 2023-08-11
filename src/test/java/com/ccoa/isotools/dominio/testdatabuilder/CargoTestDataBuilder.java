package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;

public class CargoTestDataBuilder {

    private String nombre;
    private Area area;

    public CargoTestDataBuilder() {

        this.nombre = "nombre";
        this.area = Area.of("Tec");
    }

    public CargoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CargoTestDataBuilder conArea(Area area) {
        this.area = area;
        return this;
    }

    public Cargo build() {return Cargo.of(nombre,area);}
}
