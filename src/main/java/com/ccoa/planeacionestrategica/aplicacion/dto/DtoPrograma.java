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
public class DtoPrograma {

    private String nombre;
    private String codigo;
    private Integer version;
    private Date fechaInicio;
    private Date fechaFinal;
    private Date fechaRegistro;
    private Double presupuestoIngreso;
    private Double presupuestoGasto;
    private Long idImperativoEstrategico;
    private Long idUsuario;
    private Long idArea;

}
