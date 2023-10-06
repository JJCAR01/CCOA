package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
@Getter
public class Gestion {

    //Clase de de asignacion de atributos y se validan entradas

    private final Long idGestion;
    private final String nombre;
    private final Long idPat;
    public static Gestion of(Long idGestion, String nombre, Long idPat){
        ValidadorDominio.validarObligatorio(nombre,"El nombre de la gestion del area no debe estar vacía");
        ValidadorDominio.validadorNumeroLongYMayorACero(idPat,"El Pat NO puede ser vacío");
        return new Gestion(idGestion, nombre,idPat);
    }

    public Gestion(Long idGestion, String nombre, Long idPat) {
        this.idGestion = idGestion;
        this.nombre = nombre;
        this.idPat = idPat;
    }

}
