package com.ccoa.isotools.dominio.servicio.pat;

import com.ccoa.isotools.dominio.testdatabuilder.PatTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioGuardarPat;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarPatTest {

    @Test
    void siElIdYaExisteDeberiaRetornarError() {

        //arrange
        var pat = new PatTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioPat.class);
        var servicio = new ServicioGuardarPat(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe el PAT con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () ->
                        servicio.ejecutarGuardar(pat)
                ).getMessage());
    }

    @Test
    void guardarExitoso() {

        // arrange
        var pat = new PatTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioPat.class);
        var servicio = new ServicioGuardarPat(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(Pat.class))).thenReturn(1L);
        // act
        var id = servicio.ejecutarGuardar(pat);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(pat);
        Assertions.assertEquals(1L, id);

    }
}
