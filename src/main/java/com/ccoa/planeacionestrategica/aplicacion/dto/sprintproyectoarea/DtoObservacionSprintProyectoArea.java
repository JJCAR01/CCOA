package com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoObservacionSprintProyectoArea {
    private Long idObservacionSprintProyectoArea;
    private Long idSprintProyectoArea;
    private LocalDate fecha;
    private String nombre;
}
