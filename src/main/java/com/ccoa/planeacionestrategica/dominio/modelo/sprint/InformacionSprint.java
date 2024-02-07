package com.ccoa.planeacionestrategica.dominio.modelo.sprint;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
@Data
public class InformacionSprint {
    private final double porcentajeReal;
    private final double porcentajeEsperado;
    private final double porcentajeCumplimiento;
    public static InformacionSprint of(double porcentajeReal,double porcentajeEsperado, double porcentajeCumplimiento){
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal,EL_PORCENTAJE_REAL_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeEsperado,EL_PORCENTAJE_ESPERADO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeCumplimiento,EL_PORCENTAJE_DE_CUMPLIMIENTO_NO_PUEDE_ESTAR_VACIO);
        return new InformacionSprint(porcentajeReal, porcentajeEsperado, porcentajeCumplimiento);
    }
    public InformacionSprint(double porcentajeReal, double porcentajeEsperado, double porcentajeCumplimiento) {
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
