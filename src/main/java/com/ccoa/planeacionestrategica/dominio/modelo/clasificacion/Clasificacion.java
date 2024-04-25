package com.ccoa.planeacionestrategica.dominio.modelo.clasificacion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EXCEDIO_MAXIMO_DE_CARACTERES;

@Getter
public class Clasificacion {

    private final String nombre;
    private final boolean estado;

    public static Clasificacion of(String nombre, boolean estado){
        ValidadorDominio.validadorMaximo255Caracteres(nombre,EXCEDIO_MAXIMO_DE_CARACTERES);
        return new Clasificacion(nombre,estado);
    }
    public Clasificacion(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
}
