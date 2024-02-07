package com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoObservacionActividadEstrategica {
    private Long idObservacionActividadEstrategica;
    private Long idActividadEstrategica;
    private LocalDate fecha;
    private String nombre;
}
