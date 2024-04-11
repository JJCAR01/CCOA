package com.ccoa.planeacionestrategica.dominio.transversal.servicio;

import java.time.LocalDate;

public interface ServicioCambiarFecha {
    LocalDate calcular(LocalDate fecha, Integer fechaAnual);
}
