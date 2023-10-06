package com.ccoa.planeacionestrategica.aplicacion.dto;

import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.enums.EProceso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    private EProceso proceso;
    private Long idUsuario;

}
