package com.ccoa.planeacionestrategica.aplicacion.dto.proyecto;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EModalidad;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPlaneacionSprint;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoProyecto {
    private Long idProyecto;
    private String nombre;
    private Double presupuesto;
    private EModalidad modalidad;
    private Double valorEjecutado;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Integer duracion;
    private double porcentajeReal;
    private double porcentajeEsperado;
    private double porcentajeCumplimiento;
    private Integer totalSprint;
    private EPlaneacionSprint planeacionSprint;
    private Long idActividadEstrategica;
    private Long idUsuario;
}
