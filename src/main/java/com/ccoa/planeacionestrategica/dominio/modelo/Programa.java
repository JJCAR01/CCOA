package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.Validador;
import lombok.Getter;

import java.util.Date;

@Getter
public class Programa {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final String codigo;
    private final Integer version;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final Date fechaRegistro;
    private final Double presupuestoIngreso;
    private final Double presupuestoGasto;
    private final ImperativoEstrategico imperativoEstrategico;
    private final Usuario usuario;
    private final Area area;

    public static Programa of(String nombre,String codigo,Integer version,Date fechaInicio, Date fechaFinal,
                              Date fechaRegistro,Double presupuestoIngreso,Double presupuestoGasto, ImperativoEstrategico imperativoEstrategico,
                              Usuario usuario, Area area){
        Validador.validarObligatorio(nombre,"El nombre del programa NO debe estar vacío");
        Validador.validarObligatorio(codigo,"El codigo NO debe estar vacío");
        Validador.validadorNumeroEnteroYMayorACero(version,"La version del programa debe ser mayor a cero y NO puede estar vacío");
        Validador.validarObligatorioTipoDato(fechaInicio,"La fecha de inicio del programa NO debe estar vacía");
        Validador.validarObligatorioTipoDato(fechaFinal,"La fecha final del programa NO debe estar vacía");
        Validador.validarObligatorioTipoDato(fechaRegistro,"La fecha de registro del programa NO debe estar vacía");
        Validador.validadorNumeroDoubleYMayorACero(presupuestoIngreso,"El presupuesto de ingreso del programa debe ser mayor a cero y NO puede estar vacío");
        Validador.validadorNumeroDoubleYMayorACero(presupuestoGasto," El presupuesto de gasto del programa debe ser mayor a cero y NO puede estar vacío");
        Validador.validarObjeto(imperativoEstrategico,"El imperativo estragico NO debe estar vacío");
        Validador.validarObjeto(usuario,"El usuario NO debe estar vacío");
        Validador.validarObjeto(area,"El area NO debe estar vacío");

        return new Programa(nombre,codigo,version,fechaInicio,fechaFinal,fechaRegistro,presupuestoIngreso,presupuestoGasto,
                imperativoEstrategico,usuario,area);
    }

    public Programa(String nombre, String codigo, Integer version, Date fechaInicio, Date fechaFinal, Date fechaRegistro,
                    Double presupuestoIngreso, Double presupuestoGasto, ImperativoEstrategico imperativoEstrategico, Usuario usuario, Area area) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.version = version;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.presupuestoIngreso = presupuestoIngreso;
        this.presupuestoGasto = presupuestoGasto;
        this.imperativoEstrategico = imperativoEstrategico;
        this.usuario = usuario;
        this.area = area;
    }
}
