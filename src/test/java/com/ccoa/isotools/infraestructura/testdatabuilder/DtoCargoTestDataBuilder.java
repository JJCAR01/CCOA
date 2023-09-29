package com.ccoa.isotools.infraestructura.testdatabuilder;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoCargo;

public class DtoCargoTestDataBuilder {

    private long idCargo;
    private String nombre;
    private long idArea;

    public DtoCargoTestDataBuilder() {
        this.idCargo = 1;
        this.nombre = "Auxiliar";
        this.idArea = 1;
    }

    public DtoCargoTestDataBuilder conIdCargo(Long idCargo) {
        this.idCargo = idCargo;
        return this;
    }
    public DtoCargoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public DtoCargoTestDataBuilder conIdArea(Long idArea) {
        this.idArea = idArea;
        return this;
    }

    public DtoCargo build() {
        return new DtoCargo(idCargo, nombre,idArea);
    }

}
