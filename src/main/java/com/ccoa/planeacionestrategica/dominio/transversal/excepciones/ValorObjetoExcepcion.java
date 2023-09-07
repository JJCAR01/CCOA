package com.ccoa.planeacionestrategica.dominio.transversal.excepciones;

import com.ccoa.planeacionestrategica.infraestructura.excepcion.BaseExcepcion;

public class ValorObjetoExcepcion extends BaseExcepcion {

    public ValorObjetoExcepcion(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
