package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionActividadGestionActividadEstrategica {

    private final Long idObservacionActividadGestionActividadEstrategica;
    private final Long idActividadGestionActividadEstrategica;
    private final LocalDate fecha;
    private final String nombre;

    public static ObservacionActividadGestionActividadEstrategica of(Long idObservacionActividadGestionActividadEstrategica,
                                                                     Long idActividadGestionActividadEstrategica, LocalDate fecha, String nombre){
        return new ObservacionActividadGestionActividadEstrategica(idObservacionActividadGestionActividadEstrategica, idActividadGestionActividadEstrategica, fecha, nombre);
    }

    public ObservacionActividadGestionActividadEstrategica(Long idObservacionActividadGestionActividadEstrategica,
                                                           Long idActividadGestionActividadEstrategica, LocalDate fecha, String nombre) {
        this.idObservacionActividadGestionActividadEstrategica = idObservacionActividadGestionActividadEstrategica;
        this.idActividadGestionActividadEstrategica = idActividadGestionActividadEstrategica;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
