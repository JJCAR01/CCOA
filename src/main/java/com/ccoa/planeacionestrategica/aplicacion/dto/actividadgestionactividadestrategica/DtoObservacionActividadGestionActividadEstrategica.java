package com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoObservacionActividadGestionActividadEstrategica {
    private Long idObservacionActividadGestionActividadEstrategica;
    private Long idActividadGestionActividadEstrategica;
    private LocalDate fecha;
    private String nombre;
}
