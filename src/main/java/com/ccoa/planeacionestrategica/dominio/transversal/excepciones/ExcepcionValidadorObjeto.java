package com.ccoa.planeacionestrategica.dominio.transversal.excepciones;

import com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion.BaseExcepcion;

public class ExcepcionValidadorObjeto extends BaseExcepcion {

    public ExcepcionValidadorObjeto(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
