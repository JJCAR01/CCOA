package com.ccoa.isotools.dominio.testdatabuilder.proyecto;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.enums.EPlaneacionSprint;

import java.time.LocalDate;

public class InformacionProyectoTestDataBuilder {
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final Integer duracion;
    private final EPlaneacionSprint planeacionSprint;
    private final Integer totalSprint;
    public InformacionProyectoTestDataBuilder() {
        this.fechaInicial = LocalDate.of(2024,5,12);
        this.fechaFinal = LocalDate.of(2024,6,12);
        this.duracion = 5;
        this.planeacionSprint = EPlaneacionSprint.QUINCENAL;
        this.totalSprint = 1;
    }
    /*public InformacionProyecto build() {
        return InformacionProyecto.of(fechaInicial,fechaFinal,duracion,planeacionSprint,totalSprint);
    }*/
}
