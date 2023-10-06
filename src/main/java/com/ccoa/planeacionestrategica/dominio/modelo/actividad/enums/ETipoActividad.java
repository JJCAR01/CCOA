package com.ccoa.planeacionestrategica.dominio.modelo.actividad.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ETipoActividad {

    GESTION_AREA,
    PROYECTO;

    @JsonValue
    public String toValue() {
        return name().toLowerCase(); // Convierte el valor del enumerado a minúsculas
    }
}
