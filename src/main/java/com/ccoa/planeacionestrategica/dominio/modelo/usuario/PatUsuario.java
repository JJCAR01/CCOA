package com.ccoa.planeacionestrategica.dominio.modelo.usuario;

import lombok.Data;

@Data
public class PatUsuario {

    //Clase de de asignacion de atributos y se validan entradas
    private final String nombre;


    public PatUsuario( String nombre) {
        this.nombre = nombre;
    }
}