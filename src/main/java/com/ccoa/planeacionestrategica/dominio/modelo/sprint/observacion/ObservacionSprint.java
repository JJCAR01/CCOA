package com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionSprint {
    private final Long idObservacionSprint;
    private final Long idSprint;
    private final LocalDate fecha;
    private final String nombre;

    public static ObservacionSprint of(Long idObservacionSprint, Long idSprint, LocalDate fecha, String nombre){
        return new ObservacionSprint(idObservacionSprint, idSprint, fecha, nombre);
    }

    public ObservacionSprint(Long idObservacionSprint, Long idSprint, LocalDate fecha, String nombre) {
        this.idObservacionSprint = idObservacionSprint;
        this.idSprint = idSprint;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
