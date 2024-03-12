package com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoObservacionActividadGestion {
    private Long idObservacionActividadGestion;
    private Long idActividadGestion;
    private LocalDate fecha;
    private String descripcion;
}
