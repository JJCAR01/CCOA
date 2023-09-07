package com.ccoa.planeacionestrategica.dominio.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DtoUsuarioResumen {

    private String nombre;
    private String apellidos;
    private String password;
    private String correo;
    private Long cargo;
}
