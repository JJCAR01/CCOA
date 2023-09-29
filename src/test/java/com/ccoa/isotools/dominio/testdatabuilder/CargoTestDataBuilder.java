package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;

public class CargoTestDataBuilder {

    private long idCargo;
    private String nombre;
    private long idArea;

    public CargoTestDataBuilder() {
        this.idCargo = 1;
        this.nombre = "Tec 1";
        this.idArea = 1;
    }
    public CargoTestDataBuilder conIdCargo(Long idCargo) {
        this.idCargo = idCargo;
        return this;
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
        return Cargo.of(idCargo,nombre,idArea);
    }

}
