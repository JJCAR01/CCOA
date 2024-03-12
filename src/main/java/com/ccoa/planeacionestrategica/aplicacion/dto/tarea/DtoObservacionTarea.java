package com.ccoa.planeacionestrategica.aplicacion.dto.tarea;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoObservacionTarea {
    private Long idObservacionTarea;
    private Long idTarea;
    private LocalDate fecha;
    private String descripcion;
}
