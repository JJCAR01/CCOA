package com.ccoa.planeacionestrategica.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoSprintResumen {
    private Long idSprint;
    private String descripcion;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Double avance;
    private Boolean estado;
    private Long idProyecto;
}
