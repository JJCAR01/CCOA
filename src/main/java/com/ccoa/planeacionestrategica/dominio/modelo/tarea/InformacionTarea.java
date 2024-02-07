package com.ccoa.planeacionestrategica.dominio.modelo.tarea;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidad;
import com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Data
public class InformacionTarea {

    private final EPeriodicidad periodicidad;
    private final double porcentajeReal;
    private final double porcentajeEsperado;
    private final double porcentajeCumplimiento;

    public static InformacionTarea of(EPeriodicidad periodicidad, double porcentajeReal, double porcentajeEsperado, double porcentajeCumplimiento) {
        ValidadorDominio.validarObligatorio(periodicidad, Mensajes.LA_PERIODICIDAD_DE_LA_TAREA_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal, EL_PORCENTAJE_REAL_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal, EL_PORCENTAJE_ESPERADO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal, EL_PORCENTAJE_DE_CUMPLIMIENTO_NO_PUEDE_ESTAR_VACIO);
        return new InformacionTarea(periodicidad, porcentajeReal, porcentajeEsperado, porcentajeCumplimiento);
    }

    public InformacionTarea(EPeriodicidad periodicidad, double porcentajeReal, double porcentajeEsperado, double porcentajeCumplimiento) {
        this.periodicidad = periodicidad;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
