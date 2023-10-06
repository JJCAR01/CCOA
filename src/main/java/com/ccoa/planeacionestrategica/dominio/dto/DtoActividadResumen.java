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
public class DtoActividadResumen {
    private Long idActividad;
    private String tipoActividad;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Integer duracion;
    private Integer diasRestantes;
    private Double avance;

}
