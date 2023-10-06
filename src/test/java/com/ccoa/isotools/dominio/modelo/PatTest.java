package com.ccoa.isotools.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValidadorFecha;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorCaracteresExcepcion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorNumeroExcepcion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.enums.EProceso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class PatTest {

    @Test
    void validarCreacionExitosa() {

        long idPat = 1;
        String nombre = "PAT";
        Integer fechaAnual = 2023;
        LocalDate fechaRegistro = LocalDate.now();
        Double procentaje = 0.0;
        EProceso proceso = EProceso.SERVICIOS_TI;
        long idUsuario = 1;

        Pat pat = Pat.of(idPat,nombre,fechaAnual,fechaRegistro,procentaje,proceso,idUsuario);

        Assertions.assertEquals(1,pat.getIdPat());
        Assertions.assertEquals("PAT",pat.getNombre());
        Assertions.assertEquals(2023, pat.getFechaAnual());
        Assertions.assertEquals(LocalDate.now(), pat.getFechaRegistro());
        Assertions.assertEquals(0.0, pat.getPorcentaje());
        Assertions.assertEquals(EProceso.SERVICIOS_TI, pat.getProceso());
        Assertions.assertEquals(1,pat.getIdUsuario());
    }


    @Test
    void validarCamposFaltantesNombre() {

        long idPat = 1;
        String nombre = "";
        Integer fechaAnual = 2023;
        LocalDate fechaRegistro = LocalDate.now();
        Double procentaje = 0.0;
        EProceso proceso = EProceso.SERVICIOS_TI;
        long idUsuario = 1;


        Assertions.assertEquals("El nombre del PAT NO puede estar vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Pat.of(idPat,nombre,fechaAnual,fechaRegistro,procentaje,proceso,idUsuario)
        ).getMessage());
    }

    @Test
    void validarCamposVaciosIdUsuario() {

        long idPat = 1;
        String nombre = "PAT";
        Integer fechaAnual = 2023;
        LocalDate fechaRegistro = LocalDate.now();
        Double procentaje = 0.0;
        EProceso proceso = EProceso.SERVICIOS_TI;
        long idUsuario = -1;

        Assertions.assertEquals("El usuario No puede ser vacío",Assertions.assertThrows(ValorNumeroExcepcion.class, () ->
                Pat.of(idPat,nombre,fechaAnual,fechaRegistro,procentaje,proceso,idUsuario)
        ).getMessage());
    }
    @Test
    void validarFechaRegstroActual() {

        long idPat = 1;
        String nombre = "PAT";
        Integer fechaAnual = 2023;
        LocalDate fechaRegistro = LocalDate.of(2023,9,3);
        Double procentaje = 0.0;
        EProceso proceso = EProceso.SERVICIOS_TI;
        long idUsuario = -1;

        Assertions.assertEquals("La fecha de registro NO debe ser vacío",Assertions.assertThrows(ValidadorFecha.class, () ->
                Pat.of(idPat,nombre,fechaAnual,fechaRegistro,procentaje,proceso,idUsuario)
        ).getMessage());
    }
}
