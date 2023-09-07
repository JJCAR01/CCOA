package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class Pat {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idPat;
    private final String nombre;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;
    private final Double porcentajeReal;
    private final Double porcentajeEsperado;
    private final Double cumplimiento;
    private final Long idUsuario;

    public static Pat of(Long idPat,String nombre,LocalDate fechaInicio,LocalDate fechaFinal,LocalDate fechaRegistro,
                         Double porcentajeReal,Double porcentajeEsperado,Double cumplimiento, Long idUsuario ){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del PAT NO puede estar vacío");
        ValidadorDominio.fechaInicioEsMayorActual(fechaInicio,"La fecha de Inicio debe ser mayor a la actual");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"El dato fecha de inicio NO puede estar vacío");
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicio,"La fecha Final debe ser mayor a la fecha de Inicio");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"El dato fecha de final NO puede estar vacío");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha de registro NO debe ser vacío");
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeReal,"Porcentaje real null o es menor a 0");
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeEsperado,"Porcentaje esperado null o es menor a 0");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El usuario No puede ser vacío");
        return new Pat(idPat, nombre,fechaInicio,fechaFinal,fechaRegistro,porcentajeReal,porcentajeEsperado,cumplimiento,idUsuario);
    }

    public static Pat listar(Long idPat,String nombre,LocalDate fechaInicio,LocalDate fechaFinal,LocalDate fechaRegistro,
                             Double porcentajeReal,Double porcentajeEsperado,Double cumplimiento, Long idUsuario){
        return new Pat(idPat, nombre,fechaInicio,fechaFinal,fechaRegistro,porcentajeReal,porcentajeEsperado,cumplimiento,idUsuario);
    }

    public Pat(Long idPat, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Double porcentajeReal,
               Double porcentajeEsperado, Double cumplimiento, Long idUsuario ) {
        this.idPat = idPat;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.cumplimiento = cumplimiento;
        this.idUsuario = idUsuario;
    }
}
