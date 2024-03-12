package com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoObservacionActividadGestionEstrategica {
    private Long idObservacionActividadGestionEstrategica;
    private Long idActividadGestionEstrategica;
    private LocalDate fecha;
    private String descripcion;
}
