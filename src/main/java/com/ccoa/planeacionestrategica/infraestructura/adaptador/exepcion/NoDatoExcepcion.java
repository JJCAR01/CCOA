package com.ccoa.planeacionestrategica.infraestructura.adaptador.exepcion;

public class NoDatoExcepcion extends BaseExcepcion {
    protected NoDatoExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
