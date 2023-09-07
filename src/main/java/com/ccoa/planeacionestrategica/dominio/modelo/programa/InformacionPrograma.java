package com.ccoa.planeacionestrategica.dominio.modelo.programa;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

@Getter
public class InformacionPrograma {

    private final Double porcentajeReal;
    private final Double porcentajeEsperado;
    private final Double cumplimiento;
    private final Double presupuestoIngreso;
    private final Double presupuestoGasto;

    public static InformacionPrograma of(Double porcentajeReal, Double porcentajeEsperado, Double cumplimiento,
                                         Double presupuestoIngreso, Double presupuestoGasto){
        ValidadorDominio.validadorNumeroDoubleYMayorACero(presupuestoIngreso,"El presupuesto de ingreso del programa debe ser mayor a cero y NO puede estar vacío");
        ValidadorDominio.validadorNumeroDoubleYMayorACero(presupuestoGasto," El presupuesto de gasto del programa debe ser mayor a cero y NO puede estar vacío");

        return new InformacionPrograma(porcentajeReal, porcentajeEsperado, cumplimiento, presupuestoIngreso, presupuestoGasto);
    }

    public InformacionPrograma(Double porcentajeReal, Double porcentajeEsperado, Double cumplimiento, Double presupuestoIngreso, Double presupuestoGasto) {
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.cumplimiento = cumplimiento;
        this.presupuestoIngreso = presupuestoIngreso;
        this.presupuestoGasto = presupuestoGasto;
    }


}
