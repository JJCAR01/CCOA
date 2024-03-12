package com.ccoa.planeacionestrategica.aplicacion.dto.proyecto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoObservacionProyecto {
    private Long idObservacionProyecto;
    private Long idProyecto;
    private LocalDate fecha;
    private String descripcion;
}
