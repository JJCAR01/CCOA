package com.ccoa.isotools.dominio.testdatabuilder.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;

import java.time.LocalDate;

public class InformacionActividadGestionTestDataBuilder {
    private final LocalDate fechaRegistro;
    private final Integer duracion;
    private final Integer diasRestantes;
    private final Double avance;
    public InformacionActividadGestionTestDataBuilder() {
        this.fechaRegistro = LocalDate.now();
        this.duracion = 5;
        this.diasRestantes = 5;
        this.avance = 15.4;
    }

    /*public InformacionActividadGestion build() {
        return InformacionActividadGestion.of(fechaRegistro,duracion,diasRestantes,avance);
    }*/
}
