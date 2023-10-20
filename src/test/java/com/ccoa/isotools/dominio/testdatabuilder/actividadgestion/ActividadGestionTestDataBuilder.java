package com.ccoa.isotools.dominio.testdatabuilder.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;

import java.time.LocalDate;

public class ActividadGestionTestDataBuilder {
    private final long idActividadGestion;
    private final String nombre;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final long idUsuario;
    private final long idPat;

    public ActividadGestionTestDataBuilder() {
        this.idActividadGestion = 1;
        this.nombre ="Actividad gestion test";
        this.fechaInicial = LocalDate.of(2024,5,12);
        this.fechaFinal = LocalDate.of(2024,6,12);
        this.idUsuario = 1;
        this.idPat = 1;
    }

    public ActividadGestion build() {
        return ActividadGestion.of(idActividadGestion,nombre,fechaInicial,fechaFinal,idUsuario,idPat);
    }
}
