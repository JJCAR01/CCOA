package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.Validador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rol {

    //Clase de de asignacion de atributos y se validan entradas

    private final String rol;
    private final String descripcion;

    public static Rol of(String rol,String descripcion){
        Validador.validarObligatorio(rol,"El rol NO puede ser vacío");
        return new Rol(rol,descripcion);
    }

    public Rol(String rol, String descripcion) {
        this.rol = rol;
        this.descripcion = descripcion;
    }
}
