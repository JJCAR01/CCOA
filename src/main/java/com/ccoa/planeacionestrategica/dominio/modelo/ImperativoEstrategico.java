package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
public class ImperativoEstrategico {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final LocalDateTime fechaRegistro;
    private final Double porcentajeReal;
    private final Double porcentajeEsperado;
    private final Double cumplimiento;
    private final Long idPat;
    private final Long idUsuario;

    public static ImperativoEstrategico of(String nombre, Date fechaInicio, Date fechaFinal, LocalDateTime fechaRegistro,
                                           Double porcentajeReal,Double porcentajeEsperado,Double cumplimiento,Long idPat, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del Imperativo Estraegico NO debe estar vacío");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"La fecha de inicio del Imperativo estrategico NO debe estar vacía");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha final NO del Imperativo estrategico  debe estar vacía");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha de registro  del Imperativo estrategico NO debe estar vacía");
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeReal,"Porcentaje real null o es menor a 0");
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeEsperado,"Porcentaje esperado null o es menor a 0");
        ValidadorDominio.validarObjeto(idPat, "El Pat NO debe de estar vacío");
        ValidadorDominio.validarObjeto(idUsuario, "El Usuario NO debe de estar vacío");
        return new ImperativoEstrategico(nombre,fechaInicio,fechaFinal,fechaRegistro,porcentajeReal,porcentajeEsperado,cumplimiento,idPat,idUsuario);
    }

    public ImperativoEstrategico(String nombre, Date fechaInicio, Date fechaFinal, LocalDateTime fechaRegistro, Double porcentajeReal,
                                 Double porcentajeEsperado, Double cumplimiento, Long idPat, Long idUsuario) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.cumplimiento = cumplimiento;
        this.idPat = idPat;
        this.idUsuario = idUsuario;
    }
}
