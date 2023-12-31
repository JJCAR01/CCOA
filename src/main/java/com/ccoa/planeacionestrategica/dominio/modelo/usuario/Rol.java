package com.ccoa.planeacionestrategica.dominio.modelo.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Rol {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idRol;
    private final String nombreRol;

    public static Rol of(Long idRol,String rol) {
        return new Rol(idRol,rol);
    }

    public Rol(Long idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }
}
