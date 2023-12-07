package com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion;

public class AccessDeniedExcepcion extends BaseExcepcion{
    protected AccessDeniedExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
