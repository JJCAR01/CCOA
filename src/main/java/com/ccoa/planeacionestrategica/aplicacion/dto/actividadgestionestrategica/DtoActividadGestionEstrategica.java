package com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoActividadGestionEstrategica {

    private Long idActividadGestionEstrategica;
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
    private Long idActividadEstrategica;
}
