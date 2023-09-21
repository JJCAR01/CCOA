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
public class DtoPat {

    private Long idPat;
    private String nombre;
    private LocalDate fechaAnual;
    private LocalDate fechaRegistro;
    private Double porcentaje;
    private String proceso;
    private Long idUsuario;

}
