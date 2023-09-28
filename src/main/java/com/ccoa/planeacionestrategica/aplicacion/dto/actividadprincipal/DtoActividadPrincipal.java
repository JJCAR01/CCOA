package com.ccoa.planeacionestrategica.aplicacion.dto.actividadprincipal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class  DtoActividadPrincipal {

    private Long idActividadPrincipal;
    private String nombre;
    private String tipoActividad;
    private String entregable;
    private Double presupuesto;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Long idLineaEstrategica;
    private Long idUsuario;
    private Long idTipoGI;
}