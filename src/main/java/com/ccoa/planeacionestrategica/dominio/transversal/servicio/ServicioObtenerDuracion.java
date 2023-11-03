package com.ccoa.planeacionestrategica.dominio.transversal.servicio;


import java.time.LocalDate;

public interface ServicioObtenerDuracion {
    Integer calcular(LocalDate fechaIncial, LocalDate fechaFinal);
}
