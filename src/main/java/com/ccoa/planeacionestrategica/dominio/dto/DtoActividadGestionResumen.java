package com.ccoa.planeacionestrategica.dominio.dto;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoActividadGestionResumen {
    private Long idActividadGestion;
    private String nombre;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Integer duracion;
    private Integer diasRestantes;
    private double porcentajeReal;
    private double porcentajeEsperado;
    private double porcentajeCumplimiento;
    private Long idUsuario;
    private Long idPat;

}
