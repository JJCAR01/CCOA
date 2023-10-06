package com.ccoa.isotools.dominio.modelo.actividad;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.Actividad;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.enums.ETipoActividad;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValidadorFecha;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ActividadTest {

    @Test
    void validarCreacionExitosa() {

        long idActividad = 1;
        ETipoActividad tipoActividad = ETipoActividad.PROYECTO;
        LocalDate fechaInicial = LocalDate.of(2023,12,3);
        LocalDate fechaFinal = LocalDate.of(2024,12,3);
        long idInformacionActividad = 1;

        Actividad actividad = Actividad.of(idActividad, tipoActividad,fechaInicial,fechaFinal,idInformacionActividad);

        Assertions.assertEquals(1,actividad.getIdActividad());
        Assertions.assertEquals(ETipoActividad.PROYECTO,actividad.getTipoActividad());
        Assertions.assertEquals(LocalDate.of(2023,12,3), actividad.getFechaInicial());
        Assertions.assertEquals(LocalDate.of(2024,12,3), actividad.getFechaFinal());
        Assertions.assertEquals(1,actividad.getIdInformacionActividad());
    }


    @Test
    void validarCamposFaltantesTipoActividad() {

        long idActividad = 1;
        ETipoActividad tipoActividad = null;
        LocalDate fechaInicial = LocalDate.of(2023,12,3);
        LocalDate fechaFinal = LocalDate.of(2024,12,3);
        long idInformacionActividad = 1;


        Assertions.assertEquals("El Tipo de actividad NO puede estar vacía",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Actividad.of(idActividad, tipoActividad,fechaInicial,fechaFinal,idInformacionActividad)
        ).getMessage());
    }

    @Test
    void validarFechaInicialEsMenorALaFechaFinal() {

        long idActividad = 1;
        ETipoActividad tipoActividad = ETipoActividad.PROYECTO;
        LocalDate fechaInicial = LocalDate.of(2022,12,3);
        LocalDate fechaFinal = LocalDate.of(2024,12,3);
        long idInformacionActividad = -1;

        Assertions.assertEquals("La fecha inicial no puede ser mayor a la fecha final",Assertions.assertThrows(ValidadorFecha.class, () ->
                Actividad.of(idActividad, tipoActividad,fechaInicial,fechaFinal,idInformacionActividad)
        ).getMessage());
    }
}