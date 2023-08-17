package com.ccoa.planeacionestrategica.infraestructura.adaptador.exepcion;

import lombok.Getter;

@Getter
public class BaseExcepcion extends RuntimeException{

    private final String mensajeTecnico;
    private final String mensajeHumano;

    protected BaseExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico);
        this.mensajeTecnico = mensajeTecnico;
        this.mensajeHumano = mensajeHumano ;
    }
}
