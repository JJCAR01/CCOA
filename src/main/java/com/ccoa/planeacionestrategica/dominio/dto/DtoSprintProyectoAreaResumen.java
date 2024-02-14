package com.ccoa.planeacionestrategica.dominio.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoSprintProyectoAreaResumen {
    private Long idSprintProyectoArea;
    private String descripcion;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double porcentajeCumplimiento;
    private Long idProyecto;
}
