package com.ccoa.isotools.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.isotools.dominio.testdatabuilder.AreaTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioGuardarArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarAreaTest {

    @Test
    void siElNombreYaExisteDebeRetornarError(){

        var area = new AreaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioArea.class);
        var servicio = new ServicioGuardarArea(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("Ya existe el Area con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class,()->
                        servicio.ejecutarGuardar(area)).getMessage());

    }

    @Test
    void guardarExitosamente() {

        var area = new AreaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioArea.class);
        var servicio = new ServicioGuardarArea(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(Area.class))).thenReturn(1l);

        var id = servicio.ejecutarGuardar(area);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(area);
        Assertions.assertEquals(1l, id);

    }
}
