package com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionSprintProyectoArea {
    private final Long idObservacionSprintProyectoArea;
    private final Long idSprintProyectoArea;
    private final LocalDate fecha;
    private final String nombre;

    public static ObservacionSprintProyectoArea of(Long idObservacionSprintProyectoArea, Long idSprint, LocalDate fecha, String nombre){
        return new ObservacionSprintProyectoArea(idObservacionSprintProyectoArea, idSprint, fecha, nombre);
    }

    public ObservacionSprintProyectoArea(Long idObservacionSprintProyectoArea, Long idSprintProyectoArea, LocalDate fecha, String nombre) {
        this.idObservacionSprintProyectoArea = idObservacionSprintProyectoArea;
        this.idSprintProyectoArea = idSprintProyectoArea;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
