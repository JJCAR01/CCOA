package com.ccoa.planeacionestrategica.dominio.modelo.proyecto.observacion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Data
public class ObservacionProyecto {
    private final Long idObservacionProyecto;
    private final Long idProyecto;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionProyecto of(Long idObservacionProyecto, Long idProyecto, LocalDate fecha, String descripcion){
        ValidadorDominio.validadorMaximo255Caracteres(descripcion,EXCEDIO_MAXIMO_DE_CARACTERES);
        return new ObservacionProyecto(idObservacionProyecto,idProyecto, fecha, descripcion);
    }

    public ObservacionProyecto(Long idObservacionProyecto, Long idProyecto, LocalDate fecha, String descripcion) {
        this.idObservacionProyecto = idObservacionProyecto;
        this.idProyecto = idProyecto;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
