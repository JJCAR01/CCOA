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
    private long idProyecto;
    private String nombre;
    private Double presupuesto;
    private String modalidad;
    private Double valorEjecutado;
    private Boolean estado;
    private Long idActividadEstrategica;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Double avance;
    private Integer duracion;
    private Integer totalSprint;
    private String planeacionSprint;
    private Long idUsuario;
}
