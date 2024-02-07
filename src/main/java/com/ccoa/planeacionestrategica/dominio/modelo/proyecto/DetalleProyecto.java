package com.ccoa.planeacionestrategica.dominio.modelo.proyecto;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;


@Getter
@Setter
public class DetalleProyecto {

    private final Integer duracion;
    private final double porcentajeReal;
    private final double porcentajeEsperado;
    private final double porcentajeCumplimiento;

    public static DetalleProyecto of(Integer duracion, double porcentajeReal, double porcentajeEsperado, double porcentajeCumplimiento){

        ValidadorDominio.validadorNumeroEnteroYMayorACero(duracion,LA_DURACION_NO_PUEDE_SER_NEGATIVA);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal,EL_PORCENTAJE_REAL_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeEsperado,EL_PORCENTAJE_ESPERADO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeCumplimiento,EL_PORCENTAJE_DE_CUMPLIMIENTO_NO_PUEDE_ESTAR_VACIO);
        return new DetalleProyecto(duracion, porcentajeReal, porcentajeEsperado, porcentajeCumplimiento);
    }

    public DetalleProyecto(Integer duracion, double porcentajeReal, double porcentajeEsperado, double porcentajeCumplimiento) {
        this.duracion = duracion;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
