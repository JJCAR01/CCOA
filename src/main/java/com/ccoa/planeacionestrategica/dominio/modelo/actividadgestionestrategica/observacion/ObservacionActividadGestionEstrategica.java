package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.observacion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Data
public class ObservacionActividadGestionEstrategica {
    private final Long idObservacionActividadGestionEstrategica;
    private final Long idActividadGestionEstrategica;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionActividadGestionEstrategica of(Long idObservacionActividadGestionEstrategica, Long idActividadGestionEstrategica, LocalDate fecha,
                                                            String descripcion){
        ValidadorDominio.validadorMaximo255Caracteres(descripcion,EXCEDIO_MAXIMO_DE_CARACTERES);
        return new ObservacionActividadGestionEstrategica(idObservacionActividadGestionEstrategica,idActividadGestionEstrategica, fecha, descripcion);
    }

    public ObservacionActividadGestionEstrategica(Long idObservacionActividadGestionEstrategica, Long idActividadGestionEstrategica, LocalDate fecha, String descripcion) {
        this.idObservacionActividadGestionEstrategica = idObservacionActividadGestionEstrategica;
        this.idActividadGestionEstrategica = idActividadGestionEstrategica;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
