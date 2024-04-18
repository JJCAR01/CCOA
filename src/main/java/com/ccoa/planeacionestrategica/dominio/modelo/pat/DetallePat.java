package com.ccoa.planeacionestrategica.dominio.modelo.pat;

import lombok.Data;

@Data
public class DetallePat {
    private final boolean estrategica;
    private final boolean deProceso;

    public DetallePat(boolean estrategica, boolean deProceso) {
        this.estrategica = estrategica;
        this.deProceso = deProceso;
    }
}
