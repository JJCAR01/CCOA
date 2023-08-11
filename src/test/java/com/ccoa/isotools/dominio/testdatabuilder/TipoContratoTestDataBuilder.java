package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;

public class TipoContratoTestDataBuilder {

    private String nombre;

    public TipoContratoTestDataBuilder() {
        this.nombre = "nombre";
    }

    public TipoContratoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoContrato build() {return TipoContrato.of(nombre);}
}
