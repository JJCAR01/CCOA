package com.ccoa.isotools.dominio.testdatabuilder.actividadgestionactividadestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;

import java.time.LocalDate;

public class ActividadGestionActividadEstrategicaTestDataBuilder {

    private final long idActividadGestionActividadEstrategica ;
    private final String nombre;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final long idUsuario;
    private final long idActividadEstrategica ;

    public ActividadGestionActividadEstrategicaTestDataBuilder() {
        this.idActividadGestionActividadEstrategica = 1;
        this.nombre ="Actividad gestion actividad estrategica test";
        this.fechaInicial = LocalDate.of(2024,5,12);
        this.fechaFinal = LocalDate.of(2024,6,12);
        this.idUsuario = 1;
        this.idActividadEstrategica = 1;
    }
    public ActividadGestionActividadEstrategica build() {
        return ActividadGestionActividadEstrategica.of(idActividadGestionActividadEstrategica,nombre,fechaInicial,fechaFinal,idUsuario,idActividadEstrategica);
    }
}
