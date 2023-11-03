package com.ccoa.planeacionestrategica.dominio.transversal.servicio;

import java.time.LocalDate;

public interface ServicioObtenerDiasRestantes {
    Integer calcular(LocalDate fechaFinal);
}
