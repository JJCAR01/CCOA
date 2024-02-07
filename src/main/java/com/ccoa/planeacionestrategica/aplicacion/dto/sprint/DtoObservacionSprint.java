package com.ccoa.planeacionestrategica.aplicacion.dto.sprint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoObservacionSprint {
    private Long idObservacionSprint;
    private Long idSprint;
    private LocalDate fecha;
    private String nombre;
}
