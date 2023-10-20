package com.ccoa.isotools.dominio.testdatabuilder.sprint;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;

import java.time.LocalDate;

public class SprintTestDataBuilder {
    private final long idSprint;
    private final String descripcion;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final Double avance;
    private final Boolean estado;
    private final long idProyecto;
    public SprintTestDataBuilder() {
        this.idSprint = 1;
        this.descripcion = "La implementacion de Green Lake";
        this.fechaInicial = LocalDate.of(2024,5,12);
        this.fechaFinal = LocalDate.of(2024,6,12);
        this.avance = 5.0;
        this.estado = true;
        this.idProyecto = 1;
    }
    public Sprint build() {
        return Sprint.of(idSprint,descripcion,fechaInicial,fechaFinal,avance,estado,idProyecto);
    }
}
