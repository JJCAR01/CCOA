package com.ccoa.planeacionestrategica.dominio.transversal.enums;

import lombok.Getter;

@Getter
public enum EPlaneacionSprint {
    QUINCENAL(15),SEMANAL(7),MENSUAL(30);

    private final Integer dias;
    EPlaneacionSprint(int dias) {
        this.dias = dias;
    }
}
