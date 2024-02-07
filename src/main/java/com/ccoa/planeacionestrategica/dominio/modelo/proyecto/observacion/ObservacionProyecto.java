package com.ccoa.planeacionestrategica.dominio.modelo.proyecto.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionProyecto {
    private final Long idObservacionProyecto;
    private final Long idProyecto;
    private final LocalDate fecha;
    private final String nombre;

    public static ObservacionProyecto of(Long idObservacionProyecto, Long idProyecto, LocalDate fecha, String nombre){
        return new ObservacionProyecto(idObservacionProyecto,idProyecto, fecha, nombre);
    }

    public ObservacionProyecto(Long idObservacionProyecto, Long idProyecto, LocalDate fecha, String nombre) {
        this.idObservacionProyecto = idObservacionProyecto;
        this.idProyecto = idProyecto;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
