package com.ccoa.planeacionestrategica.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoTareaResumen {
    private Long idTarea;
    private String nombre;
    private String estado;
    private String descripcion;
    private String tipoAES;
    private Long idASE;
    private Long idUsuario;
}
