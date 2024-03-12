package com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionSprintProyectoArea {
    private final Long idObservacionSprintProyectoArea;
    private final Long idSprintProyectoArea;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionSprintProyectoArea of(Long idObservacionSprintProyectoArea, Long idSprint, LocalDate fecha, String descripcion){
        return new ObservacionSprintProyectoArea(idObservacionSprintProyectoArea, idSprint, fecha, descripcion);
    }

    public ObservacionSprintProyectoArea(Long idObservacionSprintProyectoArea, Long idSprintProyectoArea, LocalDate fecha, String descripcion) {
        this.idObservacionSprintProyectoArea = idObservacionSprintProyectoArea;
        this.idSprintProyectoArea = idSprintProyectoArea;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
