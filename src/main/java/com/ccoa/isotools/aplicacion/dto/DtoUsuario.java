package com.ccoa.isotools.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DtoUsuario {

    private String nombreUsuario;
    private String nombre;
    private String apellidos;
    private String contrasena;
    private String email;
    private DtoCargo dtoCargo;
    private DtoRol dtoRol;
}
