package com.ccoa.planeacionestrategica.infraestructura.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioCambiarFecha;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ServicioCambiarFechaAnual implements ServicioCambiarFecha {
    @Override
    public LocalDate calcular(LocalDate fecha, Integer fechaAnual) {
        return fecha.withYear(fechaAnual);
    }
}
