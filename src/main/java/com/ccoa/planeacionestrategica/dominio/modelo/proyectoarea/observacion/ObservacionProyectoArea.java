package com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionProyectoArea {
    private final Long idObservacionProyectoArea;
    private final Long idProyectoArea;
    private final LocalDate fecha;
    private final String nombre;

    public static ObservacionProyectoArea of(Long idObservacionProyectoArea, Long idProyectoArea, LocalDate fecha, String nombre){
        return new ObservacionProyectoArea(idObservacionProyectoArea,idProyectoArea, fecha, nombre);
    }

    public ObservacionProyectoArea(Long idObservacionProyectoArea, Long idProyectoArea, LocalDate fecha, String nombre) {
        this.idObservacionProyectoArea = idObservacionProyectoArea;
        this.idProyectoArea = idProyectoArea;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
