package com.ccoa.planeacionestrategica.infraestructura.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPlaneacionSprint;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerSprint;
import org.springframework.stereotype.Component;

@Component
public class ServicioCalcularTotalSprint implements ServicioObtenerSprint {
    @Override
    public Integer calcular(Integer duracion, EPlaneacionSprint planeacionSprint) {
        int diasPorSprint = planeacionSprint.getDias();

        return (duracion / diasPorSprint);
    }
}
