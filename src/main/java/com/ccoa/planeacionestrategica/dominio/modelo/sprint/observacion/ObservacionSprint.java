package com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Data
public class ObservacionSprint {
    private final Long idObservacionSprint;
    private final Long idSprint;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionSprint of(Long idObservacionSprint, Long idSprint, LocalDate fecha, String descripcion){
        ValidadorDominio.validadorMaximo255Caracteres(descripcion,EXCEDIO_MAXIMO_DE_CARACTERES);
        return new ObservacionSprint(idObservacionSprint, idSprint, fecha, descripcion);
    }

    public ObservacionSprint(Long idObservacionSprint, Long idSprint, LocalDate fecha, String descripcion) {
        this.idObservacionSprint = idObservacionSprint;
        this.idSprint = idSprint;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
