package com.ccoa.planeacionestrategica.aplicacion.dto.programa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoEpica {

    private Long idEpica;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Long idUsuario;
    private Integer duracion;
    private Integer diasRestantes;
    private Boolean estado;
    private Double avance;

}
