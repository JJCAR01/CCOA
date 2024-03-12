package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionActividadEstrategica {
    private final Long idObservacionActividadEstrategica;
    private final Long idActividadEstrategica;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionActividadEstrategica of( Long idObservacionActividadEstrategica, Long idActividadEstrategica, LocalDate fecha, String descripcion){
        return new ObservacionActividadEstrategica(idObservacionActividadEstrategica,idActividadEstrategica, fecha, descripcion);
    }

    public ObservacionActividadEstrategica(Long idObservacionActividadEstrategica, Long idActividadEstrategica, LocalDate fecha, String descripcion) {
        this.idObservacionActividadEstrategica = idObservacionActividadEstrategica;
        this.idActividadEstrategica = idActividadEstrategica;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
