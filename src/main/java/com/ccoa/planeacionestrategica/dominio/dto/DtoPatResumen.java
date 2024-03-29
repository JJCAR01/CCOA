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
    private Double porcentajePat;
    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double porcentajeCumplimiento;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private DtoDireccion direccion;
    private Long idUsuario;
}
