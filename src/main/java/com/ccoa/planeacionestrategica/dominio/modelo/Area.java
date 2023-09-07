package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

@Getter
public class Area {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idArea;
    private final String nombre;

    public static Area of(Long idArea,String nombre){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del Area NO puede estar vacío");
        return new Area(idArea, nombre);
    }

    public Area(Long idArea, String nombre) {
        this.idArea = idArea;
        this.nombre = nombre;
    }
}
