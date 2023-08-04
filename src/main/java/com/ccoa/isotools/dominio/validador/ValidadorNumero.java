package com.ccoa.isotools.dominio.validador;

public class ValidadorNumero {

    public static void validadorNumeroEnteroMayorACero(Integer valor,String mensaje){

        if((valor <= 0) || (valor == null)){
            throw new IllegalArgumentException(mensaje);
        }
    }

    public ValidadorNumero() {
    }

    public static void validadorNumeroDoubleMayorACero(Double valor, String mensaje) {

        if((valor <= 0) || (valor == null)){
            throw new IllegalArgumentException(mensaje);
        }
    }
}
