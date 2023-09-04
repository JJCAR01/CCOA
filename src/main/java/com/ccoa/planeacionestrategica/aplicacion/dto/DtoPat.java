package com.ccoa.planeacionestrategica.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoPat {

    private String nombre;
    private Date fechaInicio;
    private Date fechaFinal;
    private LocalDateTime fechaRegistro;
    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double cumplimiento;
    private Long idUsuario;

}
