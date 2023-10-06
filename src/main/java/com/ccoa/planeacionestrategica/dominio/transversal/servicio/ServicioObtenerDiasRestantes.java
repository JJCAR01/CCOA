package com.ccoa.planeacionestrategica.dominio.transversal.servicio;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ServicioObtenerDiasRestantes {
    public Integer ejecutar(LocalDate fechaInicio, LocalDate fechaFinal) {
        return Math.toIntExact(ChronoUnit.DAYS.between(fechaInicio, fechaFinal));
    }
}
