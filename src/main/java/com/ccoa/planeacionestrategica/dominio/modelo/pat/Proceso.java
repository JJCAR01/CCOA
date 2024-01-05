package com.ccoa.planeacionestrategica.dominio.modelo.pat;

import lombok.Getter;

@Getter
public class Proceso {

    private final Long idProceso;
    private final String nombre;

    public Proceso(Long idProceso, String nombre) {
        this.idProceso = idProceso;
        this.nombre = nombre;
    }
}
