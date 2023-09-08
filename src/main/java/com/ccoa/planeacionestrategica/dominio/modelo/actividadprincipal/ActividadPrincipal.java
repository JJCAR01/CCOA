package com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class ActividadPrincipal {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idActividadPrincipal;
    private final String nombre;
    private final String tipoActividad;
    private final String entregable;
    private final Double presupuesto;


    public static ActividadPrincipal of(Long idActividadPrincipal,String nombre,String tipoActividad, String entregable, Double presupuesto){
        ValidadorDominio.validarObligatorio(nombre,"El nombre de la actividad principal NO debe estar vacía");
        ValidadorDominio.validarObligatorio(tipoActividad,"El tipo de actividad NO debe estar vacío");
        ValidadorDominio.validarObligatorio(entregable,"El entregable  de la actividad principal NO debe estar vacía");
        ValidadorDominio.validadorNumeroDoubleYMayorACero(presupuesto,"El presupesto de la actividad principal NO debe estar vacía");

        return new ActividadPrincipal(idActividadPrincipal, nombre,tipoActividad, entregable, presupuesto);
    }

    public static ActividadPrincipal listar(Long idActividadPrincipal,String nombre,String tipoActividad, String entregable, Double presupuesto) {
        return new ActividadPrincipal(idActividadPrincipal, nombre,tipoActividad, entregable, presupuesto);
    }

    public ActividadPrincipal(Long idActividadPrincipal, String nombre, String tipoActividad, String entregable, Double presupuesto) {
        this.idActividadPrincipal = idActividadPrincipal;
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.entregable = entregable;
        this.presupuesto = presupuesto;
    }
}
