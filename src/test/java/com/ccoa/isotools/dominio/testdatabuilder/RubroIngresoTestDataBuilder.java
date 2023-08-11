package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;

public class RubroIngresoTestDataBuilder {

    private String nombre;

    public RubroIngresoTestDataBuilder() {
        this.nombre = "nombre";
    }

    public RubroIngresoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public RubroIngreso build() {return RubroIngreso.of(nombre);}
}
