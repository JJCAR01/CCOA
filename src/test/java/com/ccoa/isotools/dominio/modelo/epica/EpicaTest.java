package com.ccoa.isotools.dominio.modelo.epica;

import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValidadorFecha;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorNumeroExcepcion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class EpicaTest {
    @Test
    void validarCreacionExitosa() {

        long idEpica = 1;
        String nombre = "EpicaTest";
        LocalDate fechaInicial = LocalDate.of(2023,12,3);
        LocalDate fechaFinal = LocalDate.of(2024,12,3);
        LocalDate fechaRegistro = LocalDate.now();
        long idUsuario = 1;
        long idPat = 1;

        Epica epica = Epica.of(idEpica,nombre,fechaInicial,fechaFinal,fechaRegistro,idUsuario,idPat);

        Assertions.assertEquals(1,epica.getIdEpica());
        Assertions.assertEquals("EpicaTest",epica.getNombre());
        Assertions.assertEquals(LocalDate.of(2023,12,3), epica.getFechaInicial());
        Assertions.assertEquals(LocalDate.of(2024,12,3), epica.getFechaFinal());
        Assertions.assertEquals(LocalDate.now(), epica.getFechaRegistro());
        Assertions.assertEquals(1,epica.getIdUsuario());
        Assertions.assertEquals(1,epica.getIdPat());
    }


    @Test
    void validarCamposFaltantesTipoActividad() {

        long idEpica = 1;
        String nombre = "";
        LocalDate fechaInicial = LocalDate.of(2023,12,3);
        LocalDate fechaFinal = LocalDate.of(2024,12,3);
        LocalDate fechaRegistro = LocalDate.now();
        long idUsuario = 1;
        long idPat = 1;


        Assertions.assertEquals("El Nombre de la Epica NO puede estar vacía",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Epica.of(idEpica,nombre,fechaInicial,fechaFinal,fechaRegistro,idUsuario,idPat)
        ).getMessage());
    }

    @Test
    void validarFechaInicialEsMayorALaFechaFinal() {

        long idEpica = 1;
        String nombre = "EpicaTest";
        LocalDate fechaInicial = LocalDate.of(2025,12,3);
        LocalDate fechaFinal = LocalDate.of(2024,12,3);
        LocalDate fechaRegistro = LocalDate.now();
        long idUsuario = 1;
        long idPat = 1;


        Assertions.assertEquals("La fecha inicial no puede ser mayor a la fecha final",Assertions.assertThrows(ValidadorFecha.class, () ->
                Epica.of(idEpica,nombre,fechaInicial,fechaFinal,fechaRegistro,idUsuario,idPat)
        ).getMessage());
    }
    @Test
    void validarUsuario() {

        long idEpica = 1;
        String nombre = "EpicaTest";
        LocalDate fechaInicial = LocalDate.of(2023,12,3);
        LocalDate fechaFinal = LocalDate.of(2024,12,3);
        LocalDate fechaRegistro = LocalDate.now();
        long idUsuario = -1;
        long idPat = 1;

        Assertions.assertEquals("El Usuario NO puede estar vacío",Assertions.assertThrows(ValorNumeroExcepcion.class, () ->
                Epica.of(idEpica,nombre,fechaInicial,fechaFinal,fechaRegistro,idUsuario,idPat)
        ).getMessage());
    }
    @Test
    void validarPat() {

        long idEpica = 1;
        String nombre = "EpicaTest";
        LocalDate fechaInicial = LocalDate.of(2023,12,3);
        LocalDate fechaFinal = LocalDate.of(2024,12,3);
        LocalDate fechaRegistro = LocalDate.now();
        long idUsuario = 1;
        long idPat = -1;

        Assertions.assertEquals("El Pat NO puede estar vacío",Assertions.assertThrows(ValorNumeroExcepcion.class, () ->
                Epica.of(idEpica,nombre,fechaInicial,fechaFinal,fechaRegistro,idUsuario,idPat)
        ).getMessage());
    }
}
