package com.ccoa.planeacionestrategica.aplicacion.dto.tarea;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoObservacionTarea {
    private Long idObservacionTarea;
    private Long idTarea;
    private LocalDate fecha;
    private String nombre;
}
