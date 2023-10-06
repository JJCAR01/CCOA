package com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion;

import java.io.Serial;

public class AutorizacionExcepcion extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public AutorizacionExcepcion(String message) {
        super(message);
    }
}
