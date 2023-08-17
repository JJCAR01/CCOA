package com.ccoa.planeacionestrategica.dominio.validador;

public class ValidadorNumero {

    public static void validadorNumeroEnteroYMayorACero(Integer valor, String mensaje){

        if((valor <= 0) || (valor == null)){
            throw new IllegalArgumentException(mensaje);
        }
    }

    private ValidadorNumero() {
    }

    public static void validadorNumeroDoubleYMayorACero(Double valor, String mensaje) {

        if((valor <= 0) || (valor == null)){
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static void validadorNumeroLongYMayorACero(Long valor, String mensaje) {

        if((valor <= 0) || (valor == null)){
            throw new IllegalArgumentException(mensaje);
        }
    }
}
