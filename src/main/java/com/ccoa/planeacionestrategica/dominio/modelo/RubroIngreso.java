package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorArgumento;
import lombok.Getter;

@Getter
public class RubroIngreso {

    private final String nombre;

    public static RubroIngreso of(String nombre){
        ValidadorArgumento.validarObligatorio(nombre,"El nombre del Rubro de Ingreso NO puede estar vacío");
        return new RubroIngreso(nombre);
    }

    public RubroIngreso(String nombre) {
        this.nombre = nombre;
    }
}
