package com.ccoa.planeacionestrategica.dominio.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class Rol {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idRol;
    private final String rol;

    public static Rol of(Long idRol, String rol) {
        return new Rol(idRol,rol);
    }

    public Rol(Long idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
    }
}
