package com.ccoa.planeacionestrategica.aplicacion.dto.actividad;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.enums.ETipoActividad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoActividad {
    private Long idActividad;
    private ETipoActividad tipoActividad;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Long idInformacionActividad;
    private Integer duracion;
    private Integer diasRestantes;
    private Double avance;
    private Long idEpica;
    private Long idGestion;
}
