package com.ccoa.isotools.dominio.modelo;

import com.ccoa.isotools.dominio.validador.ValidadorArgumento;
import lombok.Getter;

@Getter
public class TipoActividad {

    private final String nombre;

    public static TipoActividad of(String nombre){
        ValidadorArgumento.validarObligatorio(nombre,"El nombre del tipo de actividad debe NO puede ser vacío");
        return new TipoActividad(nombre);
    }

    public TipoActividad(String nombre) {
        this.nombre = nombre;
    }
}
