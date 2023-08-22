package com.ccoa.planeacionestrategica.dominio.validador.excepcion;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.exepcion.BaseExcepcion;

public class LongitudMaxExcepcion extends BaseExcepcion {
    public LongitudMaxExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
