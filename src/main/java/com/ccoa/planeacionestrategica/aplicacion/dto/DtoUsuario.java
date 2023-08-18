package com.ccoa.planeacionestrategica.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DtoUsuario {

    private String nombreUsuario;
    private String nombre;
    private String apellidos;
    private String password;
    private String correo;
    private Long idCargo;
    private Long idRol;
}
