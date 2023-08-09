package com.ccoa.isotools.dominio.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AreaTest {

    @Test
    void validarCreacionExitosa(){

        String nombre  = "Tecnologia";

        Area area = Area.of(nombre);

        Assertions.assertEquals("Tecnologia",area.getNombre());
    }

    @Test
    void validarCamposFaltantes(){

        String nombre = null;

        Assertions.assertEquals("El nobre NO puede estar vacío",Assertions.assertThrows(IllegalArgumentException.class,() ->
                Area.of(nombre)).getMessage());
    }

    @Test
    void validarCamposVacios(){

        String nombre = "";

        Assertions.assertEquals("El nobre NO puede estar vacío",Assertions.assertThrows(IllegalArgumentException.class,() ->
                Area.of(nombre)).getMessage());
    }
}
