package com.ccoa.planeacionestrategica.dominio.modelo.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Data
public class InformacionPat {

    private Long idInformacionPat;
    private Proceso proceso;
    private Direccion direccion;
    private double porcentajeReal;
    private double porcentajeEsperado;
    private double porcentajeCumplimiento;

    public static InformacionPat of(Long idInformacionPat, Proceso proceso, Direccion direccion, double porcentajeReal,
                                    double porcentajeEsperado, double porcentajeCumplimiento){
        ValidadorDominio.validarObligatorio(proceso,EL_PROCESO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(direccion,LA_DIRECCION_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeReal,EL_PORCENTAJE_REAL_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeEsperado,EL_PORCENTAJE_ESPERADO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeCumplimiento,EL_PORCENTAJE_DE_CUMPLIMIENTO_NO_PUEDE_ESTAR_VACIO);
        return new InformacionPat(idInformacionPat,proceso ,direccion,porcentajeReal,porcentajeEsperado,porcentajeCumplimiento);
    }

    public InformacionPat(Long idInformacionPat, Proceso proceso, Direccion direccion, double porcentajeReal,
                          double porcentajeEsperado, double porcentajeCumplimiento) {
        this.idInformacionPat = idInformacionPat;
        this.proceso = proceso;
        this.direccion = direccion;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
