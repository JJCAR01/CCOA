package com.ccoa.planeacionestrategica.dominio.dto;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidad;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoTareaResumen {
    private Long idTarea;
    private String nombre;
    private String estado;
    private String descripcion;
    private EPeriodicidad periodicidad;
    private Double porcentajeReal;
    private String tipoAES;
    private Long idASE;
    private Long idUsuario;
}
