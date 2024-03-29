package com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoObservacionProyectoArea {
    private Long idObservacionProyectoArea;
    private Long idProyectoArea;
    private LocalDate fecha;
    private String descripcion;
}
