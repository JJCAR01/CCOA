package com.ccoa.planeacionestrategica.dominio.modelo.pat;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionPat {

    private final Long idObservacionPat;
    private final Long idPat;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionPat of(Long idObservacionPat, Long idPat, LocalDate fecha, String descripcion){
        return new ObservacionPat(idObservacionPat,idPat, fecha, descripcion);
    }

    public ObservacionPat(Long idObservacionPat, Long idPat, LocalDate fecha, String descripcion) {
        this.idObservacionPat = idObservacionPat;
        this.idPat = idPat;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
