package com.ccoa.planeacionestrategica.dominio.transversal.excepciones;

import com.ccoa.planeacionestrategica.infraestructura.excepcion.BaseExcepcion;

public class ValidadorFechaMayor extends BaseExcepcion {

    public ValidadorFechaMayor(String mensajeTecnico, String mensajeHumano) {
        super(mensajeTecnico, mensajeHumano);
    }
}
