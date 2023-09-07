package com.ccoa.planeacionestrategica.aplicacion.dto.usuario;

import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DtoUsuario {

    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String password;
    private String correo;
    private Long idCargo;
    private List<Rol> roles;
}
