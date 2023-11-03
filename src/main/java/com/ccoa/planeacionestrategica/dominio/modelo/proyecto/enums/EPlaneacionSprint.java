package com.ccoa.planeacionestrategica.dominio.modelo.proyecto.enums;

import lombok.Getter;

@Getter
public enum EPlaneacionSprint {
    QUINCENAL(13),SEMANAL(6),MENSUAL(27);

    private final Integer dias;
    EPlaneacionSprint(int dias) {
        this.dias = dias;
    }
}
