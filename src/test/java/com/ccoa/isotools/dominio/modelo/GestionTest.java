package com.ccoa.isotools.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorNumeroExcepcion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GestionTest {

    @Test
    void validarCreacionExitosa() {

        long idGestion = 1;
        String nombre= "Tec 1";
        long idPat = 1;

        Gestion gestion = Gestion.of(idGestion, nombre,idPat);

        Assertions.assertEquals(1L,gestion.getIdGestion());
        Assertions.assertEquals("Tec 1", gestion.getNombre());
        Assertions.assertEquals(1L,gestion.getIdPat());
    }

    @Test
    void validarCamposFaltantesNombre() {

        long idGestion = 1;
        String nombre= null;
        long idPat = 1;

        Assertions.assertEquals("El nombre de la gestion del area no debe estar vacía",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Gestion.of(idGestion, nombre,idPat)
        ).getMessage());
    }

    @Test
    void validarCamposFaltantesIdArea() {

        long idGestion = 1;
        String nombre= "Tec 1";
        long idPat = -1;

        Assertions.assertEquals("El Pat NO puede ser vacío",Assertions.assertThrows(ValorNumeroExcepcion.class, () ->
                Gestion.of( idGestion,nombre,idPat)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {

        long idGestion = 1;
        String nombre= "";
        long idPat = 1;

        Assertions.assertEquals("El nombre de la gestion del area no debe estar vacía",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Gestion.of(idGestion,nombre,idPat)
        ).getMessage());
    }
}
