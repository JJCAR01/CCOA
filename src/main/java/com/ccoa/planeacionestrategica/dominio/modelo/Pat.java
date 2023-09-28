package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class Pat {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idPat;
    private final String nombre;
    private final Integer fechaAnual;
    private final LocalDate fechaRegistro;
    private final Double porcentaje;
    private final String proceso;
    private final Long idUsuario;

    public static Pat of(Long idPat,String nombre,Integer fechaAnual,LocalDate fechaRegistro,
                         Double porcentaje,String proceso, Long idUsuario ){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del PAT NO puede estar vacío");
        ValidadorDominio.validadorNumeroEnteroYMayorACero(fechaAnual,"El dato fecha de inicio NO puede estar vacío");
        ValidadorDominio.siEsFechaActualRegistrada(fechaRegistro,"La fecha de registro NO debe ser vacío");
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentaje,"Porcentaje no de debe estar nulo o es menor a 0");
        ValidadorDominio.validarObligatorio(proceso,"El proceso del programa no debe estar vacio");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El usuario No puede ser vacío");
        return new Pat(idPat, nombre,fechaAnual, fechaRegistro,porcentaje,proceso,idUsuario);
    }

    public static Pat listar(Long idPat, String nombre, Integer fechaAnual, LocalDate fechaRegistro, Double porcentaje, String proceso, Long idUsuario){
        return new Pat(idPat, nombre,fechaAnual, fechaRegistro,porcentaje,proceso,idUsuario);
    }

    public Pat(Long idPat, String nombre, Integer fechaAnual, LocalDate fechaRegistro, Double porcentaje, String proceso, Long idUsuario) {
        this.idPat = idPat;
        this.nombre = nombre;
        this.fechaAnual = fechaAnual;
        this.fechaRegistro = fechaRegistro;
        this.porcentaje = porcentaje;
        this.proceso = proceso;
        this.idUsuario = idUsuario;
    }
}
