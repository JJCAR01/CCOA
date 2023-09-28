package com.ccoa.planeacionestrategica.dominio.modelo.registroactividad;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RegistroActividad {

    //Clase de de asignacion de atributos y se validan entradas

    private final String comentario;
    private final Double porcentaje;
    private final LocalDate fechaRegistro;
    private final Long idActividadPrincipal;
    private final Long idUsuario;

    public static RegistroActividad of(String comentario, Double porcentaje, LocalDate fechaRegistro,Long idActividadPrincipal, Long idUsuario){
        ValidadorDominio.validarObligatorio(comentario,"El comentario del registro de la actividad no puede ser vacío");
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentaje,"El porcentaje del registro de la actividad no puede ser vacío o menor a cero");
        ValidadorDominio.validadorNumeroLongYMayorACero(idActividadPrincipal,"El id de la actividad principal no puede estar vacía");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El id del usuario no puede estar vacío");
        return new RegistroActividad(comentario, porcentaje, fechaRegistro,idActividadPrincipal,idUsuario);
    }

    public static RegistroActividad listar(String comentario, Double porcentaje, LocalDate fechaRegistro,Long idActividadPrincipal, Long idUsuario){
        return new RegistroActividad(comentario, porcentaje, fechaRegistro,idActividadPrincipal,idUsuario);
    }

    public RegistroActividad(String comentario, Double porcentaje, LocalDate fechaRegistro,Long idActividadPrincipal, Long idUsuario) {
        this.comentario = comentario;
        this.porcentaje = porcentaje;
        this.fechaRegistro = fechaRegistro;
        this.idActividadPrincipal = idActividadPrincipal;
        this.idUsuario = idUsuario;
    }
}
