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
public class DtoProyectoResumen {
    private String nombre;
    private Double presupuesto;
    private String modalidad;
    private Double valorEjecutado;
    private Boolean estado;
    private Long idActividadEstrategica;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Integer duracion;
    private Integer totalSprint;
    private String planeacionSprint;
}
