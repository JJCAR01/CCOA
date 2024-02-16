package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
public class InformacionActividadEstrategica {

    private final Integer duracion;
    private final Integer diasRestantes;
    private final double porcentajeReal;
    private final double porcentajeEsperado;
    private final double porcentajeCumplimiento;
    public static InformacionActividadEstrategica of(Integer duracion, Integer diasRestantes, double porcentajeReal,
                                                     double porcentajeEsperado, double porcentajeCumplimiento) {
        ValidadorDominio.validadorNumeroEnteroYMayorACero(duracion,LA_DURACION_NO_PUEDE_SER_NEGATIVA);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal, EL_PORCENTAJE_REAL_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal, EL_PORCENTAJE_ESPERADO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal, EL_PORCENTAJE_DE_CUMPLIMIENTO_NO_PUEDE_ESTAR_VACIO);
        return new InformacionActividadEstrategica(duracion, diasRestantes, porcentajeReal, porcentajeEsperado, porcentajeCumplimiento);
    }
        public InformacionActividadEstrategica(Integer duracion, Integer diasRestantes, double porcentajeReal,
                                           double porcentajeEsperado, double porcentajeCumplimiento) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
