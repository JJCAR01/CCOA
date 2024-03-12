package com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionProyectoArea {
    private final Long idObservacionProyectoArea;
    private final Long idProyectoArea;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionProyectoArea of(Long idObservacionProyectoArea, Long idProyectoArea, LocalDate fecha, String descripcion){
        return new ObservacionProyectoArea(idObservacionProyectoArea,idProyectoArea, fecha, descripcion);
    }

    public ObservacionProyectoArea(Long idObservacionProyectoArea, Long idProyectoArea, LocalDate fecha, String descripcion) {
        this.idObservacionProyectoArea = idObservacionProyectoArea;
        this.idProyectoArea = idProyectoArea;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
