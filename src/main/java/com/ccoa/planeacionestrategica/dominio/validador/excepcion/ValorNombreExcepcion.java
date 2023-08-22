package com.ccoa.planeacionestrategica.dominio.validador.excepcion;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.exepcion.BaseExcepcion;

public class ValorNombreExcepcion extends BaseExcepcion {

    public ValorNombreExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
