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
    private final double porcentajePat;
    public static InformacionActividadEstrategica of(Integer duracion, Integer diasRestantes, double porcentajeReal,
                                                     double porcentajeEsperado, double porcentajeCumplimiento, double porcentajePat) {
        ValidadorDominio.validadorNumeroEnteroYMayorACero(duracion,LA_DURACION_NO_PUEDE_SER_NEGATIVA);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal, EL_PORCENTAJE_REAL_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal, EL_PORCENTAJE_ESPERADO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal, EL_PORCENTAJE_DE_CUMPLIMIENTO_NO_PUEDE_ESTAR_VACIO);
        return new InformacionActividadEstrategica(duracion, diasRestantes, porcentajeReal, porcentajeEsperado, porcentajeCumplimiento, porcentajePat);
    }
        public InformacionActividadEstrategica(Integer duracion, Integer diasRestantes, double porcentajeReal,
                                               double porcentajeEsperado, double porcentajeCumplimiento, double porcentajePat) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
            this.porcentajePat = porcentajePat;
        }
}
