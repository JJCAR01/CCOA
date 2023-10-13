package com.ccoa.planeacionestrategica.dominio.modelo.proyecto;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.enums.EPlaneacionSprint;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
@Getter
@Setter
public class InformacionProyecto {

    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final Integer duracion;
    private final EPlaneacionSprint planeacionSprint;
    private final Integer totalSprint;
    public static InformacionProyecto of(LocalDate fechaInicial, LocalDate fechaFinal, Integer duracion, EPlaneacionSprint planeacionSprint, Integer totalSprint){
        ValidadorDominio.validarObligatorioTipoDato(fechaInicial, LA_FECHA_INICIAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,LA_FECHA_FINAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicial,LA_FECHA_FINAL_DEBE_SER_MAYOR_A_LA_FECHA_INICIAL);
        ValidadorDominio.validarObligatorio(planeacionSprint,LA_PLANEACION_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroEnteroYMayorACero(totalSprint,EL_NUMERO_TOTAL_DE_SPRINT_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        return new InformacionProyecto(fechaInicial, fechaFinal, duracion, planeacionSprint, totalSprint);
    }

    public InformacionProyecto(LocalDate fechaInicial, LocalDate fechaFinal, Integer duracion, EPlaneacionSprint planeacionSprint, Integer totalSprint) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.duracion = duracion;
        this.planeacionSprint = planeacionSprint;
        this.totalSprint = totalSprint;
    }
}
