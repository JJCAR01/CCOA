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
public class DtoPat {

    private String nombre;
    private Date fechaInicio;
    private Date fechaFinal;
    private Date fechaRegistro;
    private DtoUsuario dtoUsuario;

}
