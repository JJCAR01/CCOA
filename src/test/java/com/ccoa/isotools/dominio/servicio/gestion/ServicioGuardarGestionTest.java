package com.ccoa.isotools.dominio.servicio.gestion;

import com.ccoa.isotools.dominio.testdatabuilder.GestionTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.gestion.ServicioGuardarGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarGestionTest {

    @Test
    void siElIdYaExisteDeberiaRetornarError() {

        //arrange
        var gestion = new GestionTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioGestion.class);
        var servicio = new ServicioGuardarGestion(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe la gestion del area con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () ->
                        servicio.ejecutarGuardar(gestion)
                ).getMessage());
    }

    @Test
    void guardarExitoso() {

        // arrange
        var gestion = new GestionTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioGestion.class);
        var servicio = new ServicioGuardarGestion(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(Gestion.class))).thenReturn(1L);
        // act
        var id = servicio.ejecutarGuardar(gestion);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(gestion);
        Assertions.assertEquals(1L, id);

    }
}
