package com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Data
public class ObservacionProyectoArea {
    private final Long idObservacionProyectoArea;
    private final Long idProyectoArea;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionProyectoArea of(Long idObservacionProyectoArea, Long idProyectoArea, LocalDate fecha, String descripcion){
        ValidadorDominio.validadorMaximo255Caracteres(descripcion,EXCEDIO_MAXIMO_DE_CARACTERES);
        return new ObservacionProyectoArea(idObservacionProyectoArea,idProyectoArea, fecha, descripcion);
    }

    public ObservacionProyectoArea(Long idObservacionProyectoArea, Long idProyectoArea, LocalDate fecha, String descripcion) {
        this.idObservacionProyectoArea = idObservacionProyectoArea;
        this.idProyectoArea = idProyectoArea;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
