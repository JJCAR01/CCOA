package com.ccoa.planeacionestrategica.aplicacion.dto.tarea;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidad;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoTarea {
    private Long idTarea;
    private String nombre;
    private EEstado estado;
    private String descripcion;
    private EPeriodicidad periodicidad;
    private ETipoASE tipoASE;
    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double porcentajeCumplimiento;
    private Long idASE;
    private Long idUsuario;
}
