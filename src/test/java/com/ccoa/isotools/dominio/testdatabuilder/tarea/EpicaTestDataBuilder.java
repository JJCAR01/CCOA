package com.ccoa.isotools.dominio.testdatabuilder.tarea;


import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.Epica;

import java.time.LocalDate;

public class EpicaTestDataBuilder {
    private final Long idTarea;
    private final String nombre;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;
    private final Long idUsuario;
    private final Long idPat;

    public EpicaTestDataBuilder() {
        this.idTarea = 1L;
        this.nombre = "Epica";
        this.fechaInicial = LocalDate.of(2023,12,12);
        this.fechaFinal = LocalDate.of(2024,12,24);
        this.fechaRegistro = LocalDate.now();
        this.idUsuario = 1L;
        this.idPat = 1L;

    }
    public Epica build() {
        return Epica.of(idTarea,nombre,fechaInicial,fechaFinal,fechaRegistro,idUsuario,idPat);
    }
}
