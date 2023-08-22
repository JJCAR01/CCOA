package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.Getter;


@Getter
public class Rubro {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final Long idTipoGI;

    public static Rubro of(String nombre, Long idTipoGI){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del rubro NO puede estar vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idTipoGI,"El Tipo Gasto/Ingreso no puede estar vacío");
        return new Rubro(nombre,idTipoGI);
    }

    public Rubro(String nombre, Long idTipoGI) {
        this.nombre = nombre;
        this.idTipoGI = idTipoGI;
    }
}
