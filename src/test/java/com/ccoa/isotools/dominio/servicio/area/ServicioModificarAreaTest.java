package com.ccoa.isotools.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.isotools.dominio.testdatabuilder.AreaTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioModificarArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioModificarAreaTest {

    @Test
    void verifcarNoExisteArea() {
        var area = new AreaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioArea.class);
        var servicio = new ServicioModificarArea(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Area con los datos ingresados", Assertions.assertThrows(IllegalStateException.class,()->
                servicio.ejecutarModificar(area,1L)).getMessage());
    }
}