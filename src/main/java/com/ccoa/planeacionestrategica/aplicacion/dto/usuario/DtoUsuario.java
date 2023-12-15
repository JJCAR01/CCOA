package com.ccoa.planeacionestrategica.aplicacion.dto.usuario;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
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
    private List<EDireccion> direcciones;
    private List<EProceso> procesos;
    private List<Rol> roles;
}
