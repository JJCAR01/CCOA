package com.ccoa.planeacionestrategica.dominio.modelo.usuario;

import lombok.Data;
@Data

public class Rol {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idRol;
    private final String nombreRol;

    public static Rol of(Long idRol,String nombreRol) {
        return new Rol(idRol,nombreRol);
    }

    public Rol(Long idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }
}
