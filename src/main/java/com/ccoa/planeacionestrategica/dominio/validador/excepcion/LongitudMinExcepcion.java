package com.ccoa.planeacionestrategica.dominio.validador.excepcion;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.exepcion.BaseExcepcion;

public class LongitudMinExcepcion extends BaseExcepcion {
    protected LongitudMinExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}