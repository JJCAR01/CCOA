package com.ccoa.isotools.dominio.testdatabuilder.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;

import java.time.LocalDate;

public class ActividadEstrategicaTestDataBuilder {
    private long idActividadEstrategica;
    private String nombre;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;

    public ActividadEstrategicaTestDataBuilder() {
        this.idActividadEstrategica = 1;
        this.nombre = "PAT";
        this.fechaInicial = LocalDate.of(2024,5,12);
        this.fechaFinal = LocalDate.of(2024,6,10);
        this.fechaRegistro = LocalDate.now();
    }
    public ActividadEstrategica build() {
        return ActividadEstrategica.of(idActividadEstrategica,nombre,fechaInicial,fechaFinal,fechaRegistro);
    }
}
