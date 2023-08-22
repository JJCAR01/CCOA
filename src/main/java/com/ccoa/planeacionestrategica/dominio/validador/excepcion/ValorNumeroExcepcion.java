package com.ccoa.planeacionestrategica.dominio.validador.excepcion;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.exepcion.BaseExcepcion;

public class ValorNumeroExcepcion extends BaseExcepcion {
    public ValorNumeroExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
