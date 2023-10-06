package com.ccoa.planeacionestrategica.aplicacion.dto.epica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoInformacionEpica {
    private Long idInformacionEpica;
    private Integer duracion;
    private Integer diasRestantes;
    private Boolean estado;
    private Double avance;
}
