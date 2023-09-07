package com.ccoa.planeacionestrategica.dominio.transversal.excepciones;

import com.ccoa.planeacionestrategica.infraestructura.excepcion.BaseExcepcion;

public class NoDatoExcepcion extends BaseExcepcion {
    protected NoDatoExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
