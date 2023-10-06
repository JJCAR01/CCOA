package com.ccoa.isotools.dominio.testdatabuilder.actividad;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.Actividad;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.enums.ETipoActividad;

import java.time.LocalDate;

public class ActividadTestDataBuilder {
    private final Long idActividad;
    private final ETipoActividad tipoActividad;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final Long idInformacionActividad;

    public ActividadTestDataBuilder() {
        this.idActividad = 1L;
        this.tipoActividad = ETipoActividad.PROYECTO;
        this.fechaInicial = LocalDate.of(2023,12,12);
        this.fechaFinal = LocalDate.of(2023,12,24);
        this.idInformacionActividad = 1L;
    }


    public Actividad build() {
        return Actividad.of(idActividad,tipoActividad,fechaInicial,fechaFinal,idInformacionActividad);
    }

}