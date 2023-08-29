package com.ccoa.planeacionestrategica.dominio.validador.excepcion;

import com.ccoa.planeacionestrategica.infraestructura.excepcion.BaseExcepcion;

public class ValorInvalidoExcepcion extends BaseExcepcion {

    public ValorInvalidoExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
