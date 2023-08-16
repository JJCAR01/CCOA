package com.ccoa.planeacionestrategica.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class  DtoActividadPrincipal {

    private String nombre;
    private String tipoActividad;
    private String entregable;
    private Double presupuesto;
    private Date fechaInicio;
    private Date fechaFinal;
    private Date fechaRegistro;
    private DtoLineaEstrategica dtoLineaEstrategica;
    private DtoUsuario dtoUsuario;
    private DtoTipoGI dtoTipoGI;
}
