package com.ccoa.planeacionestrategica.dominio.modelo.tarea;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Data
public class ObservacionTarea {
    private final Long idObservacionTarea;
    private final Long idTarea;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionTarea of(Long idObservacionTarea, Long idTarea, LocalDate fecha, String descripcion){
        ValidadorDominio.validadorMaximo255Caracteres(descripcion,EXCEDIO_MAXIMO_DE_CARACTERES);
        return new ObservacionTarea(idObservacionTarea, idTarea, fecha, descripcion);
    }
    public ObservacionTarea(Long idObservacionTarea, Long idTarea, LocalDate fecha, String descripcion) {
        this.idObservacionTarea = idObservacionTarea;
        this.idTarea = idTarea;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
