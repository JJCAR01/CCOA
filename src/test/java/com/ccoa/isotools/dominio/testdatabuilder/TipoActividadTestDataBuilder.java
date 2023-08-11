package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;

public class TipoActividadTestDataBuilder {

    private String nombre;

    public TipoActividadTestDataBuilder() {
        this.nombre = "nombre";
    }

    public TipoActividadTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoActividad build() {return TipoActividad.of(nombre);}
}
