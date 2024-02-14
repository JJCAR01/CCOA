package com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoSprintProyectoArea {
    private Long idSprintProyectoArea;
    private String descripcion;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double porcentajeCumplimiento;
    private Long idProyectoArea;

}
