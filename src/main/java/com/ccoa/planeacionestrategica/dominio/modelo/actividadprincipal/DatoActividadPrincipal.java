package com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DatoActividadPrincipal {

    private final LocalDate fechaInicio;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;

    public static DatoActividadPrincipal of(LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro){
        ValidadorDominio.fechaInicioEsMayorActual(fechaInicio,"La fecha de Inicio debe ser mayor a la actual");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"La fecha inicio de la actividad principal NO debe estar vacía");
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicio,"La fecha Final debe ser mayor a la fecha de Inicio");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha inicial de la actividad principal NO debe estar vacía");
        ValidadorDominio.validarObligatorio(fechaRegistro,"La fecha de resgistro de la actividad principal NO debe estar vacía");

        return new DatoActividadPrincipal(fechaInicio,fechaFinal,fechaRegistro);
    }

    public DatoActividadPrincipal(LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
    }
}
