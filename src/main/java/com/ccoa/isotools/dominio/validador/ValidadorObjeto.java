package com.ccoa.isotools.dominio.validador;

public class ValidadorObjeto {

    public static void validarObjeto(Object objeto, String mensaje){
        if(objeto == null){
            throw new IllegalArgumentException(mensaje);
        }
    }

    public ValidadorObjeto() {
    }
}
