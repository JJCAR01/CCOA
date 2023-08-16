package com.ccoa.planeacionestrategica.dominio.validador;

public class ValidadorNumero {

    public static void validadorNumeroEnteroMayorACero(Integer valor,String mensaje){

        if((valor <= 0) || (valor == null)){
            throw new IllegalArgumentException(mensaje);
        }
    }

    private ValidadorNumero() {
    }

    public static void validadorNumeroDoubleMayorACero(Double valor, String mensaje) {

        if((valor <= 0) || (valor == null)){
            throw new IllegalArgumentException(mensaje);
        }
    }
}
