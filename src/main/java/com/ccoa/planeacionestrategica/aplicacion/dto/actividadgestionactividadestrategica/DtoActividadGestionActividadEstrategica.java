package com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoActividadGestionActividadEstrategica {

    private Long idActividadGestionActividadEstrategica;
    private String nombre;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Integer duracion;
    private Integer diasRestantes;
    private Double avance;
    private Long idUsuario;
    private Long idActividadEstrategica;
}
