package com.ccoa.isotools.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AreaTest {

    @Test
    void validarCreacionExitosa() {

        String nombre= "TI";

        Area area = Area.of(nombre);

        Assertions.assertEquals("TI", area.getNombre());
    }

    @Test
    void validarCamposFaltantes() {

        String nombre= null;

        Assertions.assertEquals("El nombre del Area NO puede estar vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Area.of(nombre)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {

        String nombre= "";

            Assertions.assertEquals("El nombre del Area NO puede estar vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Area.of(nombre)
        ).getMessage());
    }
}
