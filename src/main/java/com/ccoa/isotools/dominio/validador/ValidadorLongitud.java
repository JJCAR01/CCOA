package com.ccoa.isotools.dominio.validador;

public class ValidadorLongitud {

    public static void longitudPassword(String valor, String mensaje)
    {
        if(!(valor.length()>=8 && valor.length()<=15))
        {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static void longitudNombreUsuario(String valor, String mensaje)
    {
        if(!(valor.length()>=3 && valor.length()<=12))
        {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static void validadorLongitud(String valor, Long longitud, String mensaje) {
        if(valor.length() < longitud) {
            throw new IllegalArgumentException(String.format(mensaje, longitud));
        }
    }

    public ValidadorLongitud() {
    }
}
