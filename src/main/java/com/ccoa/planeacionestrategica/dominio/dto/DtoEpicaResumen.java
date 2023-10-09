package com.ccoa.planeacionestrategica.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoEpicaResumen {
    private Long idEpica;
    private String nombre;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Integer duracion;
    private Integer diasRestantes;
    private Boolean estado;
    private Double avance;
    private Long idUsuario;
    private Long idPat;


}
