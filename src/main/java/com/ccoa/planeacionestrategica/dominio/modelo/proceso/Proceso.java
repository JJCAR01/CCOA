package com.ccoa.planeacionestrategica.dominio.modelo.proceso;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Getter
public class Proceso {

    private final String nombre;

    public static Proceso of(String nombre){
        ValidadorDominio.validadorMaximo255Caracteres(nombre,EXCEDIO_MAXIMO_DE_CARACTERES);
        return new Proceso(nombre);
    }
    public Proceso(String nombre) {
        this.nombre = nombre;
    }
}
