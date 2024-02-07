package com.ccoa.planeacionestrategica.dominio.modelo.tarea;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ObservacionTarea {

    private final Long idObservacionTarea;
    private final Long idTarea;
    private final LocalDate fecha;
    private final String nombre;

    public static ObservacionTarea of(Long idObservacionTarea, Long idTarea, LocalDate fecha, String nombre){
        return new ObservacionTarea(idObservacionTarea, idTarea, fecha, nombre);
    }
    public ObservacionTarea(Long idObservacionTarea, Long idTarea, LocalDate fecha, String nombre) {
        this.idObservacionTarea = idObservacionTarea;
        this.idTarea = idTarea;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
