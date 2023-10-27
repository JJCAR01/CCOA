package com.ccoa.planeacionestrategica.infraestructura.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentajeAvance;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ServicioCalcularPorcentajeAvance implements ServicioObtenerPorcentajeAvance {
    @Override
    public double calcularPorcentaje(List<?> objecto) {
        int total = objecto.size();
        if (total > 0) {
            return (total / 100.0) * 100.0; // Suponiendo que 1000 es el número base
        } else {
            return 0.0;
        }
    }
}
