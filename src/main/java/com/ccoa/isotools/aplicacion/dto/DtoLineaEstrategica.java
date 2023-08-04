package com.ccoa.isotools.aplicacion.dto;

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
    private DtoPrograma dtoPrograma;
    private DtoUsuario dtoUsuario;

}
