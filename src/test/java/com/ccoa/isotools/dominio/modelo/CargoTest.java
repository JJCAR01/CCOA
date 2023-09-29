package com.ccoa.isotools.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorNumeroExcepcion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CargoTest {

    @Test
    void validarCreacionExitosa() {

        long idCargo = 1;
        String nombre= "Tec 1";
        long idArea = 1;

        Cargo cargo = Cargo.of(idCargo, nombre,idArea);

        Assertions.assertEquals(1L,cargo.getIdCargo());
        Assertions.assertEquals("Tec 1", cargo.getNombre());
        Assertions.assertEquals(1L,cargo.getIdArea());
    }

    @Test
    void validarCamposFaltantesNombre() {

        long idCargo = 1;
        String nombre= null;
        Long idArea = 1L;

        Assertions.assertEquals("El nombre del cargo no puede ser vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Cargo.of(idCargo, nombre,idArea)
        ).getMessage());
    }

    @Test
    void validarCamposFaltantesIdArea() {

        long idCargo = 1;
        String nombre= "Tec 1";
        Long idArea = -1L;

        Assertions.assertEquals("El area NO puede ser vacío",Assertions.assertThrows(ValorNumeroExcepcion.class, () ->
                Cargo.of( idCargo,nombre,idArea)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {

        long idCargo = 1;
        String nombre= "";
        Long idArea = 0L;

        Assertions.assertEquals("El nombre del cargo no puede ser vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Cargo.of(idCargo,nombre,idArea)
        ).getMessage());
    }

}