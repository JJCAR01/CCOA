package com.ccoa.planeacionestrategica.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DtoEpicaResumen {
    private Long idEpica;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private Long idUsuario;
    private Long idPat;
    private Integer duracion;
    private Integer diasRestantes;
    private Boolean estado;
    private Double avance;


}
