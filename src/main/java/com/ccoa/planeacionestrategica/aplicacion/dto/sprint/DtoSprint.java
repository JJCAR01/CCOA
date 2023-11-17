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
public class DtoSprint {
    private Long idSprint;
    private String descripcion;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Double avance;
    private Boolean estado;
    private Long idProyecto;

}
