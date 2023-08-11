package com.ccoa.planeacionestrategica.dominio.dto;

import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DtoPatResumen {

    private String nombre;
    private Date fechaInicio;
    private Date fechaFinal;
    private Date fechaRegistro;
    private Usuario usuario;
}
