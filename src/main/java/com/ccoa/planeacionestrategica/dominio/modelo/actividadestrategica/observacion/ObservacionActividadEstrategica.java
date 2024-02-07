package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionActividadEstrategica {

    private final Long idObservacionActividadEstrategica;
    private final Long idActividadEstrategica;
    private final LocalDate fecha;
    private final String nombre;

    public static ObservacionActividadEstrategica of(Long idObservacionActividadEstrategica, Long idActividadEstrategica, LocalDate fecha, String nombre){
        return new ObservacionActividadEstrategica(idObservacionActividadEstrategica,idActividadEstrategica, fecha, nombre);
    }

    public ObservacionActividadEstrategica(Long idObservacionActividadEstrategica, Long idActividadEstrategica, LocalDate fecha, String nombre) {
        this.idObservacionActividadEstrategica = idObservacionActividadEstrategica;
        this.idActividadEstrategica = idActividadEstrategica;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
