package com.ccoa.planeacionestrategica.dominio.modelo.tarea;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionTarea {
    private final Long idObservacionTarea;
    private final Long idTarea;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionTarea of(Long idObservacionTarea, Long idTarea, LocalDate fecha, String descripcion){
        return new ObservacionTarea(idObservacionTarea, idTarea, fecha, descripcion);
    }
    public ObservacionTarea(Long idObservacionTarea, Long idTarea, LocalDate fecha, String descripcion) {
        this.idObservacionTarea = idObservacionTarea;
        this.idTarea = idTarea;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
