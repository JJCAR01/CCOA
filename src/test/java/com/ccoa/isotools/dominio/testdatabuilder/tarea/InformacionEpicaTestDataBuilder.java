package com.ccoa.isotools.dominio.testdatabuilder.tarea;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.InformacionActividad;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;

import java.time.LocalDate;

public class InformacionEpicaTestDataBuilder {

    private final long idInformacionEpica;
    private final Integer duracion;
    private final Integer diasRestantes;
    private final Boolean estado;
    private final Double avance;
    public InformacionEpicaTestDataBuilder() {
        this.idInformacionEpica =1;
        this.duracion = 20;
        this.diasRestantes = 5;
        this.estado = true;
        this.avance = 10.0;
    }
    public InformacionEpica build() {
        return InformacionEpica.of(idInformacionEpica,duracion,diasRestantes,estado,avance);
    }
}
