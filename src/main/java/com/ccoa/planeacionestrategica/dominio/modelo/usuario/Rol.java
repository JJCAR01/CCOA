package com.ccoa.planeacionestrategica.dominio.modelo.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Rol {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idRol;
    private final String nombre;

    public static Rol of(Long idRol,String nombre) {
        return new Rol(idRol,nombre);
    }

    public Rol(Long idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }
}
