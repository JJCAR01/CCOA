package com.ccoa.isotools.dominio.testdatabuilder.actividadgestionactividadestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;

import java.time.LocalDate;

public class InformacionActividadGestionActvidadEstrategicaTestDataBuilder {
    private final LocalDate fechaRegistro;
    private final Integer duracion;
    private final Integer diasRestantes;
    private final Double avance;

    public InformacionActividadGestionActvidadEstrategicaTestDataBuilder() {
        this.fechaRegistro = LocalDate.now();
        this.duracion = 5;
        this.diasRestantes = 5;
        this.avance = 15.4;
    }
}
