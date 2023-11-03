package com.ccoa.planeacionestrategica.infraestructura.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDiasRestantes;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@Component
public class ServicioCalcularDiasRestantes implements ServicioObtenerDiasRestantes {
    @Override
    public Integer calcular(LocalDate fechaFinal) {
        return Math.toIntExact(ChronoUnit.DAYS.between(LocalDate.now(), fechaFinal));
    }
}
