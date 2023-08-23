package com.ccoa.isotools.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorNumeroExcepcion;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    void validarCreacionExitosa() {

        String nombre= "Tec 1";
        Long idArea = 1L;

        Cargo cargo = Cargo.of(nombre,idArea);

        Assertions.assertEquals("Tec 1", cargo.getNombre());
        Assertions.assertEquals(1l,cargo.getIdArea());
    }

    @Test
    void validarCamposFaltantesNombre() {

        String nombre= null;
        Long idArea = 1L;

        Assertions.assertEquals("El nombre del cargo no puede ser vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Cargo.of(nombre,idArea)
        ).getMessage());
    }

    @Test
    void validarCamposFaltantesIdArea() {

        String nombre= "Tec 1";
        Long idArea = -1l;

        Assertions.assertEquals("El area NO puede ser vacío",Assertions.assertThrows(ValorNumeroExcepcion.class, () ->
                Cargo.of(nombre,idArea)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {

        String nombre= "";
        Long idArea = 0l;

        Assertions.assertEquals("El nombre del cargo no puede ser vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Cargo.of(nombre,idArea)
        ).getMessage());
    }
}
