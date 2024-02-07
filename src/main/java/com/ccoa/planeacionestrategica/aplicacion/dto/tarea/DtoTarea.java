package com.ccoa.planeacionestrategica.aplicacion.dto.tarea;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EPeriodicidad;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoTarea {
    private Long idTarea;
    private String nombre;
    private EEstado estado;
    private String descripcion;
    private EPeriodicidad periodicidad;
    private ETipoASE tipoASE;
    private Double porcentaje;
    private Long idASE;
    private Long idUsuario;
}
