package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.Validador;
import lombok.Getter;


@Getter
public class Rubro {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final TipoGI tipoGI;

    public static Rubro of(String nombre, TipoGI tipoGI){
        Validador.validarObligatorio(nombre,"El nombre del rubro NO puede estar vacío");
        Validador.validarObjeto(tipoGI,"El Tipo Gasto/Ingreso no puede estar vacío");
        return new Rubro(nombre,tipoGI);
    }

    public Rubro(String nombre, TipoGI tipoGI) {
        this.nombre = nombre;
        this.tipoGI = tipoGI;
    }
}
