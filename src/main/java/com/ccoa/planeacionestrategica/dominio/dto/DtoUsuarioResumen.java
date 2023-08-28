package com.ccoa.planeacionestrategica.dominio.dto;


import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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
