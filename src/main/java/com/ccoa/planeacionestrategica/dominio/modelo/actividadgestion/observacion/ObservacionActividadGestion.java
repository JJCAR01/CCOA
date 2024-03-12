package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.observacion;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionActividadGestion {
    private final Long idObservacionActividadGestion;
    private final Long idActividadGestion;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionActividadGestion of(Long idObservacionActividadGestion, Long idActividadGestion, LocalDate fecha, String descripcion){
        return new ObservacionActividadGestion(idObservacionActividadGestion,idActividadGestion, fecha, descripcion);
    }

    public ObservacionActividadGestion(Long idObservacionActividadGestion, Long idActividadGestion, LocalDate fecha, String descripcion) {
        this.idObservacionActividadGestion = idObservacionActividadGestion;
        this.idActividadGestion = idActividadGestion;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
