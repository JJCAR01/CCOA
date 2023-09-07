package com.ccoa.isotools.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AreaTest {

    @Test
    void validarCreacionExitosa() {

        long idArea = 1;
        String nombre= "TI";

        Area area = Area.of(idArea, nombre);

        Assertions.assertEquals("TI", area.getNombre());
    }

    @Test
    void validarCamposFaltantes() {

        long idArea = 1;
        String nombre= null;

        Assertions.assertEquals("El nombre del Area NO puede estar vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Area.of(idArea, nombre)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {

        long idArea = 1;
        String nombre= "";

            Assertions.assertEquals("El nombre del Area NO puede estar vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Area.of(idArea,nombre)
        ).getMessage());
    }
}
