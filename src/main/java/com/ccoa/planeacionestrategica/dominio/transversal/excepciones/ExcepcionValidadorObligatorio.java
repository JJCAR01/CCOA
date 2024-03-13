package com.ccoa.planeacionestrategica.dominio.transversal.excepciones;

import com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion.BaseExcepcion;

public class ExcepcionValidadorObligatorio extends BaseExcepcion {
    public ExcepcionValidadorObligatorio(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
