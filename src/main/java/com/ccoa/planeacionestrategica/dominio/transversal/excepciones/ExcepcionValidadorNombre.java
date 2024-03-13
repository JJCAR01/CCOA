package com.ccoa.planeacionestrategica.dominio.transversal.excepciones;

import com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion.BaseExcepcion;

public class ExcepcionValidadorNombre extends BaseExcepcion {

    public ExcepcionValidadorNombre(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
