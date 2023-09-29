package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;

public class GestionTestDataBuilder {
    private long idGestion;
    private String nombre;
    private long idPat;

    public GestionTestDataBuilder() {
        this.idGestion = 1;
        this.nombre = "Gestion 1";
        this.idPat = 1;
    }
    public GestionTestDataBuilder conIdGestion(Long idGestion) {
        this.idGestion = idGestion;
        return this;
    }

    public GestionTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public GestionTestDataBuilder conIdPat(Long idPat) {
        this.idPat = idPat;
        return this;
    }

    public Gestion build() {
        return Gestion.of(idGestion,nombre,idPat);
    }

}
