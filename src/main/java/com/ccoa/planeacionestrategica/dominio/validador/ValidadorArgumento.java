package com.ccoa.planeacionestrategica.dominio.validador;

import java.util.Date;
import java.util.List;

public class ValidadorArgumento {

    public static void validarObligatorio(String valor, String mensaje) {
        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static void validarObligatorioTipoDate(Date valor, String mensaje) {
        if(valor == null) {
            throw new IllegalArgumentException(mensaje);
        }
    }


    public static void validadorNoVacio(List<? extends Object> lista, String mensaje) {
        if(lista == null  || lista.isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    private ValidadorArgumento() {
    }
}
