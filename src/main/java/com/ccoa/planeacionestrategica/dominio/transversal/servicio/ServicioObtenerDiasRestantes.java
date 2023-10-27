package com.ccoa.planeacionestrategica.dominio.transversal.servicio;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface ServicioObtenerDiasRestantes {
    Integer ejecutar(LocalDate fechaInicial, LocalDate fechaFinal);
}
