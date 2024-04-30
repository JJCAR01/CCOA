package com.ccoa.planeacionestrategica.dominio.dto;

import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoPatResumen {
    private Long idPat;
    private String nombre;
    private Integer fechaAnual;
    private LocalDate fechaRegistro;
    private double porcentajePat;
    private double porcentajeReal;
    private double porcentajeEsperado;
    private double porcentajeCumplimiento;
    private double porcentajeKPI;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private boolean estrategica;
    private boolean deProceso;
    private DtoDireccion direccion;
    private Long idUsuario;
    private Long idClasificacion;
}
