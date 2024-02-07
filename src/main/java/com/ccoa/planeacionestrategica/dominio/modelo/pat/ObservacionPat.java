package com.ccoa.planeacionestrategica.dominio.modelo.pat;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionPat {

    private final Long idObservacionPat;
    private final Long idPat;
    private final LocalDate fecha;
    private final String nombre;

    public static ObservacionPat of(Long idObservacionPat, Long idPat, LocalDate fecha, String nombre){
        return new ObservacionPat(idObservacionPat, idPat, fecha, nombre);
    }

    public ObservacionPat(Long idObservacionPat, Long idPat, LocalDate fecha, String nombre) {
        this.idObservacionPat = idObservacionPat;
        this.idPat = idPat;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
