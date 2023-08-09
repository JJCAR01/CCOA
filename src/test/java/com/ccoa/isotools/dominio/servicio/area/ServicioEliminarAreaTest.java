package com.ccoa.isotools.dominio.servicio.area;

import com.ccoa.isotools.dominio.puerto.RepositorioArea;
import com.ccoa.isotools.dominio.testdatabuilder.AreaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarAreaTest {

    @Test
    void verifcarNoExisteArea() {
        var area = new AreaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioArea.class);
        var servicio = new ServicioEliminarArea(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Area con los datos ingresados", Assertions.assertThrows(IllegalStateException.class,()->
                servicio.ejecutarEliminar(1L)).getMessage());
    }
}
