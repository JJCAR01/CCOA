package com.ccoa.planeacionestrategica.infraestructura.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerHora;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ServicioObtenerHoraActual implements ServicioObtenerHora {
    @Override
    public LocalDate ejecutar(LocalDate fecha) {
        return LocalDate.now();
    }
}
