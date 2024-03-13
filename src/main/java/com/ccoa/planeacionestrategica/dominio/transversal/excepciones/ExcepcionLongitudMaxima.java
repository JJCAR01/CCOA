package com.ccoa.planeacionestrategica.dominio.transversal.excepciones;

import com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion.BaseExcepcion;

public class ExcepcionLongitudMaxima extends BaseExcepcion {
    public ExcepcionLongitudMaxima(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
