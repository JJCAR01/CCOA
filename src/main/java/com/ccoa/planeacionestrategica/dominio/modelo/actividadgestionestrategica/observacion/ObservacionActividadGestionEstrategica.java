package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionActividadGestionEstrategica {
    private final Long idObservacionActividadGestionEstrategica;
    private final Long idActividadGestionEstrategica;
    private final LocalDate fecha;
    private final String nombre;

    public static ObservacionActividadGestionEstrategica of(Long idObservacionActividadGestionEstrategica, Long idActividadGestionEstrategica, LocalDate fecha, String nombre){
        return new ObservacionActividadGestionEstrategica(idObservacionActividadGestionEstrategica,idActividadGestionEstrategica, fecha, nombre);
    }

    public ObservacionActividadGestionEstrategica(Long idObservacionActividadGestionEstrategica, Long idActividadGestionEstrategica, LocalDate fecha, String nombre) {
        this.idObservacionActividadGestionEstrategica = idObservacionActividadGestionEstrategica;
        this.idActividadGestionEstrategica = idActividadGestionEstrategica;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
