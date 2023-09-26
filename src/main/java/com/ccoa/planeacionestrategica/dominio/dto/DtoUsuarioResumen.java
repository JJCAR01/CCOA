package com.ccoa.planeacionestrategica.dominio.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DtoUsuarioResumen {

    private Long idUsuario;
    private String nombre;
    private String apellidos;
    private String correo;
    private Long cargo;
}
