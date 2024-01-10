package com.ccoa.planeacionestrategica.dominio.dto;


import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.aplicacion.dto.proceso.DtoProceso;
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
    private List<DtoProceso> procesos;
    private Long idCargo;
}
