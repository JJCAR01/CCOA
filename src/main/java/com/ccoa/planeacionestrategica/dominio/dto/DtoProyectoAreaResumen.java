package com.ccoa.planeacionestrategica.dominio.dto;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EModalidad;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPlaneacionSprint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoProyectoAreaResumen {
    private long idProyectoArea;
    private String nombre;
    private Double presupuesto;
    private EModalidad modalidad;
    private Double valorEjecutado;
    private Integer totalSprint;
    private EPlaneacionSprint planeacionSprint;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Integer duracion;
    private double porcentajeReal;
    private double porcentajeEsperado;
    private double porcentajeCumplimiento;
    private Long idPat;
    private Long idUsuario;
}
