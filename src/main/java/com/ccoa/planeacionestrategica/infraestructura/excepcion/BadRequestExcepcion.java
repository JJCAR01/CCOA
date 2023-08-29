package com.ccoa.planeacionestrategica.infraestructura.excepcion;

public class BadRequestExcepcion extends BaseExcepcion{

    protected BadRequestExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
