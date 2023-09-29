package com.ccoa.isotools.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.isotools.dominio.testdatabuilder.AreaTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioGuardarArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarAreaTest {

    @Test
    void siElNombreYaExisteDeberiaRetornarError() {

        //arrange
        var area = new AreaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioArea.class);
        var servicio = new ServicioGuardarArea(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe el Area con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () ->
                        servicio.ejecutarGuardar(area)
                ).getMessage());
    }

    @Test
    void guardarExitoso() {

        // arrange
        var area = new AreaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioArea.class);
        var servicio = new ServicioGuardarArea(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(Area.class))).thenReturn(1L);
        // act
        var id = servicio.ejecutarGuardar(area);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(area);
        Assertions.assertEquals(1L, id);

    }

}
