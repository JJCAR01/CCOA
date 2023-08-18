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
public class DtoImperativoEstrategico {

    private String nombre;
    private Date fechaInicio;
    private Date fechaFinal;
    private Date fechaRegistro;
    private Long idPat;
    private Long idUsuario;

}
