package com.ccoa.isotools.dominio.modelo;

import com.ccoa.isotools.dominio.validador.ValidadorArgumento;
import com.ccoa.isotools.dominio.validador.ValidadorObjeto;
import lombok.Getter;

@Getter
public class Cargo {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final Area area;

    public static Cargo of(String nombre,Area area){
        ValidadorArgumento.validarObligatorio(nombre,"El nombre del cargo no puede ser vacío");
        ValidadorObjeto.validarObjeto(area,"El area NO puede ser vacío");
        return new Cargo(nombre,area);
    }

    public Cargo(String nombre, Area area) {
        this.nombre = nombre;
        this.area = area;
    }
}
