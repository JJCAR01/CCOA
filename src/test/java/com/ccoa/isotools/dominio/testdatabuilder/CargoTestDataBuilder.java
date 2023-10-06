package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;

public class CargoTestDataBuilder {

    private final long idCargo;
    private final String nombre;
    private final long idArea;

    public CargoTestDataBuilder() {
        this.idCargo = 1;
        this.nombre = "Tec 1";
        this.idArea = 1;
    }

    public Cargo build() {
        return Cargo.of(idCargo,nombre,idArea);
    }

}
