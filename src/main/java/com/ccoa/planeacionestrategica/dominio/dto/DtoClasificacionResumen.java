package com.ccoa.planeacionestrategica.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoClasificacionResumen {
    private Long idClasificacion;
    private String nombre;
    private boolean estado;
}
