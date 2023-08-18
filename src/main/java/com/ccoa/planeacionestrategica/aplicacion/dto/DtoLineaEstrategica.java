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
public class DtoLineaEstrategica {

    private String nombre;
    private String entregable;
    private Date fechaInicio;
    private Date fechaFinal;
    private Date fechaRegistro;
    private String indicadorResultado;
    private Long idPrograma;
    private Long idUsuario;

}
