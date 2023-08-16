package com.ccoa.planeacionestrategica.dominio.validador;

public class ValidadorPatron {


    private static final String PATRON_PASSWORD = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,15}";
    private static final String PATRON_CORREO = "^\\w+([.-_+]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,10})+$";
    private static final String PATRON_NOMBRE_USUARIO = "^[a-z]\\.[a-z]{2,}$";

    public static boolean aceptacionPatron(String cadena, String patron)
    {
        return cadena.matches(patron);
    }

    public static void validadorCaracteresEspecialesPassword(String password, String mensaje)
    {
        if(!aceptacionPatron(password, PATRON_PASSWORD))
        {
            throw new IllegalArgumentException(mensaje);
        }
        else{
            ValidadorLongitud.longitudPassword(password, "Valor del tamaño excedido");
        }
    }

    public static void validadorCaracteresEspecialesCorreo(String correo, String menssaje)
    {
        if(!aceptacionPatron(correo, PATRON_CORREO))
        {
            throw new IllegalArgumentException(menssaje);
        }
    }

    public static void validadorNombreUsuario(String nombreUsuario, String mensaje)
    {
        if(!aceptacionPatron(nombreUsuario, PATRON_NOMBRE_USUARIO))
        {
            throw new IllegalArgumentException(mensaje);
        }
        else{
            ValidadorLongitud.longitudNombreUsuario(nombreUsuario, "Valor del tamaño excedido");
        }
    }


}
