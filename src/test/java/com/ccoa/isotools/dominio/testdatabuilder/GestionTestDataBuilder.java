package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;

public class GestionTestDataBuilder {
    private final long idGestion;
    private final String nombre;
    private final long idPat;
    public GestionTestDataBuilder() {
        this.idGestion = 1;
        this.nombre = "Gestion 1";
        this.idPat = 1;
    }
    public Gestion build() {
        return Gestion.of(idGestion,nombre,idPat);
    }
}
