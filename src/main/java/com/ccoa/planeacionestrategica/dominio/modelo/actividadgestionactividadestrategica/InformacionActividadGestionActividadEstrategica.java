package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Data
public class InformacionActividadGestionActividadEstrategica  {

    private final Integer duracion;
    private final Integer diasRestantes;
    private final double porcentajeReal;
    private final double porcentajeEsperado;
    private final double porcentajeCumplimiento;

    public static InformacionActividadGestionActividadEstrategica of(Integer duracion, Integer diasRestantes,
                                                                     double porcentajeReal, double porcentajeEsperado, double porcentajeCumplimiento){

        ValidadorDominio.validadorNumeroEnteroYMayorACero(duracion,LA_DURACION_NO_PUEDE_SER_NEGATIVA);
        ValidadorDominio.validarObjeto(diasRestantes,LOS_DIAS_RESTANTES_NO_PUEDEN_SER_NULOS);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeReal,EL_PORCENTAJE_REAL_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeEsperado,EL_PORCENTAJE_ESPERADO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentajeCumplimiento,EL_PORCENTAJE_DE_CUMPLIMIENTO_NO_PUEDE_ESTAR_VACIO);
        return new InformacionActividadGestionActividadEstrategica(duracion, diasRestantes, porcentajeReal, porcentajeEsperado, porcentajeCumplimiento);
    }

    public InformacionActividadGestionActividadEstrategica(Integer duracion, Integer diasRestantes,
                                                           double porcentajeReal, double porcentajeEsperado, double porcentajeCumplimiento) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
