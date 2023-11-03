package com.ccoa.planeacionestrategica.infraestructura.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDuracion;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
@Component
public class ServicioCalcularDuracionDias implements ServicioObtenerDuracion {
    @Override
    public Integer calcular(LocalDate fechaIncial, LocalDate fechaFinal) {
        return Math.toIntExact(Duration.between(fechaIncial.atStartOfDay(), fechaFinal.atStartOfDay()).toDays());
    }
}
