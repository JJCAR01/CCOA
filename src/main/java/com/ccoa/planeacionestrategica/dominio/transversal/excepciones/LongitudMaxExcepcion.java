package com.ccoa.planeacionestrategica.dominio.transversal.excepciones;

import com.ccoa.planeacionestrategica.infraestructura.excepcion.BaseExcepcion;

public class LongitudMaxExcepcion extends BaseExcepcion {
    public LongitudMaxExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
