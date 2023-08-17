package com.ccoa.planeacionestrategica.infraestructura.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private String nombreExepcion;
    private String mensajeTecnico;
    private String mensajeHumano;
}

