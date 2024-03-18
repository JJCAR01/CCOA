package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Data
public class ObservacionActividadEstrategica {
    private final Long idObservacionActividadEstrategica;
    private final Long idActividadEstrategica;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionActividadEstrategica of( Long idObservacionActividadEstrategica, Long idActividadEstrategica, LocalDate fecha, String descripcion){
        ValidadorDominio.validadorMaximo255Caracteres(descripcion,EXCEDIO_MAXIMO_DE_CARACTERES);
        return new ObservacionActividadEstrategica(idObservacionActividadEstrategica,idActividadEstrategica, fecha, descripcion);
    }

    public ObservacionActividadEstrategica(Long idObservacionActividadEstrategica, Long idActividadEstrategica, LocalDate fecha, String descripcion) {
        this.idObservacionActividadEstrategica = idObservacionActividadEstrategica;
        this.idActividadEstrategica = idActividadEstrategica;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
