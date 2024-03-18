package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
public class Cargo {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idCargo;
    private final String nombre;
    private final Long idArea;

    public static Cargo of(Long idCargo,String nombre,Long idArea){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DEL_CARGO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorMaximo255Caracteres(nombre,EXCEDIO_MAXIMO_DE_CARACTERES);
        ValidadorDominio.validadorNumeroLongYMayorACero(idArea,NO_PUEDE_EXISTIR_SIN_AREA);
        return new Cargo(idCargo, nombre,idArea);
    }

    public Cargo(Long idCargo, String nombre, Long idArea) {
        this.idCargo = idCargo;
        this.nombre = nombre;
        this.idArea = idArea;
    }
}
