package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorArgumento;
import com.ccoa.planeacionestrategica.dominio.validador.ValidadorObjeto;
import lombok.Getter;


@Getter
public class Rubro {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final TipoGI tipoGI;

    public static Rubro of(String nombre, TipoGI tipoGI){
        ValidadorArgumento.validarObligatorio(nombre,"El nombre del rubro NO puede estar vacío");
        ValidadorObjeto.validarObjeto(tipoGI,"El Tipo Gasto/Ingreso no puede estar vacío");
        return new Rubro(nombre,tipoGI);
    }

    public Rubro(String nombre, TipoGI tipoGI) {
        this.nombre = nombre;
        this.tipoGI = tipoGI;
    }
}
