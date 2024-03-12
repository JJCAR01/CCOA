package com.ccoa.planeacionestrategica.dominio.dto;


import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoPatUsuario;
import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoRol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoUsuarioResumen {

    private Long idUsuario;
    private String nombre;
    private String apellidos;
    private String correo;
    private List<DtoDireccion> direcciones;
    private List<DtoPatUsuario> pats;
    private List<DtoRol> rol;
    private Long idCargo;
}
