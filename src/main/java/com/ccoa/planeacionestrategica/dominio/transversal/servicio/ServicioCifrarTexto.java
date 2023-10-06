package com.ccoa.planeacionestrategica.dominio.transversal.servicio;

public interface ServicioCifrarTexto {

    String ejecutar(String password);
    boolean existe(String password, String passwordEncriptada);
}
