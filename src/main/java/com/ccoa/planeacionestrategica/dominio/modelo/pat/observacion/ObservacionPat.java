package com.ccoa.planeacionestrategica.dominio.modelo.pat.observacion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Data
public class ObservacionPat {

    private final Long idObservacionPat;
    private final Long idPat;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionPat of(Long idObservacionPat, Long idPat, LocalDate fecha, String descripcion){
        ValidadorDominio.validadorMaximo255Caracteres(descripcion,EXCEDIO_MAXIMO_DE_CARACTERES);
        return new ObservacionPat(idObservacionPat,idPat, fecha, descripcion);
    }

    public ObservacionPat(Long idObservacionPat, Long idPat, LocalDate fecha, String descripcion) {
        this.idObservacionPat = idObservacionPat;
        this.idPat = idPat;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
