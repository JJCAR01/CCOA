package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorArgumento;

public class Rol {

    //Clase de de asignacion de atributos y se validan entradas

    private final String rol;

    public static Rol of(String rol){
        ValidadorArgumento.validarObligatorio(rol,"El rol NO puede ser vacío");
        return new Rol(rol);
    }

    public Rol(String rol) {
        this.rol = rol;
    }
}
