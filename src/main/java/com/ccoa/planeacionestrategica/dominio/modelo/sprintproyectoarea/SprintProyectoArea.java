package com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Data
public class    SprintProyectoArea {
    private final Long idSprintProyectoArea;
    private final String descripcion;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final Long idProyectoArea;

    public static SprintProyectoArea of(Long idSprintProyectoArea, String descripcion, LocalDate fechaInicial, LocalDate fechaFinal, Long idProyectoArea){
        ValidadorDominio.validarObligatorio(descripcion,LA_DESCRIPCION_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validadorMaximo255Caracteres(descripcion,EXCEDIO_MAXIMO_DE_CARACTERES);
        ValidadorDominio.validarObligatorioTipoDato(fechaInicial,LA_FECHA_INICIAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,LA_FECHA_FINAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicial,LA_FECHA_FINAL_DEBE_SER_MAYOR_A_LA_FECHA_INICIAL);
        ValidadorDominio.validarObligatorio(idProyectoArea,NO_PUEDE_EXISTIR_SIN_PROYECTO);
        return new SprintProyectoArea(idSprintProyectoArea, descripcion, fechaInicial, fechaFinal, idProyectoArea);
    }

    public SprintProyectoArea(Long idSprintProyectoArea, String descripcion, LocalDate fechaInicial, LocalDate fechaFinal, Long idProyectoArea) {
        this.idSprintProyectoArea = idSprintProyectoArea;
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idProyectoArea = idProyectoArea;
    }
}
