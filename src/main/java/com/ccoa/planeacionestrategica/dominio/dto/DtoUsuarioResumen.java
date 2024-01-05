package com.ccoa.planeacionestrategica.dominio.dto;


import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadProceso;
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
    private List<EDireccion> direcciones;
    private List<EProceso> procesos;
    private Long idCargo;
}
