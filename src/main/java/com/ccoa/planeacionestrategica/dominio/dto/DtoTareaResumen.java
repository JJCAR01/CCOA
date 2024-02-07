package com.ccoa.planeacionestrategica.dominio.dto;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EPeriodicidad;
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
    private EPeriodicidad periodicidad;
    private Double porcentaje;
    private String tipoAES;
    private Long idASE;
    private Long idUsuario;
}
