package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;

public class RubroGastoTestDataBuilder {

    private String nombre;

    public RubroGastoTestDataBuilder() {
        this.nombre = "nombre";
    }

    public RubroGastoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public RubroGasto build() {return RubroGasto.of(nombre);}
}
