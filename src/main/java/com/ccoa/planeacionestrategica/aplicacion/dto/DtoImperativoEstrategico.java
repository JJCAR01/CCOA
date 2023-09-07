package com.ccoa.planeacionestrategica.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoImperativoEstrategico {

    private Long idImperativoEstrategico;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double cumplimiento;
    private Long idPat;
    private Long idUsuario;

}
