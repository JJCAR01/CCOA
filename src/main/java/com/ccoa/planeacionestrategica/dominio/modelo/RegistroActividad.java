package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.Getter;

import java.util.Date;

@Getter
public class RegistroActividad {

    //Clase de de asignacion de atributos y se validan entradas

    private final String comentario;
    private final Double porcentaje;
    private final Date fechaRegistro;
    private final String documento;
    private final Long idActividadPrincipal;
    private final Long idUsuario;

    public static RegistroActividad of(String comentario, Double porcentaje, Date fechaRegistro, String documento, Long idActividadPrincipal, Long idUsuario){
        ValidadorDominio.validarObligatorio(comentario,"El comentario del registro de la actividad no puede ser vacío");
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentaje,"El porcentaje del registro de la actividad no puede ser vacío o menor a cero");
        ValidadorDominio.validarObligatorio(documento,"El documento NO puede estar vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idActividadPrincipal,"El id de la actividad principal no puede estar vacía");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El id del usuario no puede estar vacío");
        return new RegistroActividad(comentario, porcentaje, fechaRegistro, documento,idActividadPrincipal,idUsuario);
    }

    public RegistroActividad(String comentario, Double porcentaje, Date fechaRegistro, String documento, Long idActividadPrincipal, Long idUsuario) {
        this.comentario = comentario;
        this.porcentaje = porcentaje;
        this.fechaRegistro = fechaRegistro;
        this.documento = documento;
        this.idActividadPrincipal = idActividadPrincipal;
        this.idUsuario = idUsuario;
    }
}
