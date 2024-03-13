package com.ccoa.planeacionestrategica.dominio.transversal.excepciones;

import com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion.BaseExcepcion;

public class ExcepcionValidadorFecha extends BaseExcepcion {

    public ExcepcionValidadorFecha(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
