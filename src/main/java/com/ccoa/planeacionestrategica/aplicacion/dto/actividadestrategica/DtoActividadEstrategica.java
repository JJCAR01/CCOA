package com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoActividadEstrategica {
    private Long idActividadEstrategica;
    private String nombre;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Integer duracion;
    private Integer diasRestantes;
    private Boolean estado;
    private double porcentajeReal;
    private double porcentajeEsperado;
    private double porcentajeCumplimiento;
    private Double meta;
    private Double resultadoMeta;
    private Double promedioMeta;
    private String entregable;
    private Long idUsuario;
    private Long idPat;
}
