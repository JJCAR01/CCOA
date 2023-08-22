package com.ccoa.planeacionestrategica.dominio.validador.excepcion;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.exepcion.BaseExcepcion;

public class ValorObligatorioExcepcion extends BaseExcepcion {
    public ValorObligatorioExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
