package com.ccoa.isotools.dominio.servicio.epica;

import com.ccoa.isotools.dominio.testdatabuilder.GestionTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.tarea.EpicaTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.tarea.InformacionEpicaTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.epica.ServicioGuardarEpica;
import com.ccoa.planeacionestrategica.dominio.servicio.gestion.ServicioGuardarGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarEpicaTest {
    @Test
    void siElIdYaExisteDeberiaRetornarError() {

        //arrange
        var epica = new EpicaTestDataBuilder().build();
        var infEpica = new InformacionEpicaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioEpica.class);
        var servicio = new ServicioGuardarEpica(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe la Epica del area con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () ->
                        servicio.ejecutarGuardar(epica,infEpica)
                ).getMessage());
    }

    @Test
    void guardarExitoso() {

        // arrange
        var epica = new EpicaTestDataBuilder().build();
        var infEpica = new InformacionEpicaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioEpica.class);
        var servicio = new ServicioGuardarEpica(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(Epica.class),Mockito.any(InformacionEpica.class))).thenReturn(1L);
        // act
        var id = servicio.ejecutarGuardar(epica,infEpica);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(epica,infEpica);
        Assertions.assertEquals(1L, id);

    }
}
