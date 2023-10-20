package com.ccoa.isotools.dominio.testdatabuilder.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;

public class InformacionActividadEstrategicaTestDataBuilder {
    private final Integer duracion;
    private final Integer diasRestantes;
    private final Boolean estado;
    private final Double avance;
    private final long idUsuario;
    private final long idPat;
    public InformacionActividadEstrategicaTestDataBuilder() {
        this.duracion = 5;
        this.diasRestantes =5;
        this.estado = Boolean.TRUE;
        this.avance = 10.8;
        this.idUsuario = 1;
        this.idPat = 1;
    }
    public InformacionActividadEstrategica build() {
        return InformacionActividadEstrategica.of(duracion,diasRestantes,estado,avance,idUsuario,idPat);
    }
}
