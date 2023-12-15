package com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion;

public class AccessDeniedExcepcion extends BaseExcepcion{
    public AccessDeniedExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
