package com.ccoa.planeacionestrategica.dominio.modelo.sprint;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
@Getter
@Setter
public class Sprint {
    private final Long idSprint;
    private final String descripcion;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final Double avance;
    private final Boolean estado;
    private final Long idProyecto;

    public static Sprint of(Long idSprint, String descripcion, LocalDate fechaInicial, LocalDate fechaFinal, Double avance, Boolean estado, Long idProyecto){
        ValidadorDominio.validarObligatorio(descripcion,LA_DESCRIPCION_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validarObligatorioTipoDato(fechaInicial,LA_FECHA_INICIAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,LA_FECHA_FINAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicial,LA_FECHA_FINAL_DEBE_SER_MAYOR_A_LA_FECHA_INICIAL);
        ValidadorDominio.validarObligatorio(idProyecto,NO_PUEDE_EXISTIR_SIN_PROYECTO);
        return new Sprint(idSprint, descripcion, fechaInicial, fechaFinal, avance, estado, idProyecto);
    }

    public Sprint(Long idSprint, String descripcion, LocalDate fechaInicial, LocalDate fechaFinal, Double avance, Boolean estado, Long idProyecto) {
        this.idSprint = idSprint;
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.avance = avance;
        this.estado = estado;
        this.idProyecto = idProyecto;
    }
}
