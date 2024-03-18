package com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Data
public class ObservacionSprintProyectoArea {
    private final Long idObservacionSprintProyectoArea;
    private final Long idSprintProyectoArea;
    private final LocalDate fecha;
    private final String descripcion;

    public static ObservacionSprintProyectoArea of(Long idObservacionSprintProyectoArea, Long idSprint, LocalDate fecha, String descripcion){
        ValidadorDominio.validadorMaximo255Caracteres(descripcion,EXCEDIO_MAXIMO_DE_CARACTERES);
        return new ObservacionSprintProyectoArea(idObservacionSprintProyectoArea, idSprint, fecha, descripcion);
    }

    public ObservacionSprintProyectoArea(Long idObservacionSprintProyectoArea, Long idSprintProyectoArea, LocalDate fecha, String descripcion) {
        this.idObservacionSprintProyectoArea = idObservacionSprintProyectoArea;
        this.idSprintProyectoArea = idSprintProyectoArea;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
