package com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion;

public class BadRequestExcepcion extends BaseExcepcion{

    protected BadRequestExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
