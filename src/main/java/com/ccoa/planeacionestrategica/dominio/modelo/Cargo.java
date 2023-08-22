package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.Getter;

@Getter
public class Cargo {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final Long idArea;

    public static Cargo of(String nombre,Long idArea){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del cargo no puede ser vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idArea,"El area NO puede ser vacío");
        return new Cargo(nombre,idArea);
    }

    public Cargo(String nombre, Long idArea) {
        this.nombre = nombre;
        this.idArea = idArea;
    }
}
