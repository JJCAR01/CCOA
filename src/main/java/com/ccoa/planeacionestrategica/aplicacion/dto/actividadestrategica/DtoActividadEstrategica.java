package com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoActividadEstrategica {
    private Long idEpica;
    private String nombre;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Integer duracion;
    private Integer diasRestantes;
    private Boolean estado;
    private Double avance;
    private Long idUsuario;
    private Long idPat;
}
