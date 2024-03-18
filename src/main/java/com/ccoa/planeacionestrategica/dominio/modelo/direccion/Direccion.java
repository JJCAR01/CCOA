package com.ccoa.planeacionestrategica.dominio.modelo.direccion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Getter
public class Direccion {

    private final String nombre;

    public static Direccion of(String nombre){
        ValidadorDominio.validadorMaximo255Caracteres(nombre,EXCEDIO_MAXIMO_DE_CARACTERES);
                return new Direccion(nombre);
    }

    public Direccion( String nombre) {
        this.nombre = nombre;
    }
}
