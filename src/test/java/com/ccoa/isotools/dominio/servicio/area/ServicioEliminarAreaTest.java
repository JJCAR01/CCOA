package com.ccoa.isotools.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.isotools.dominio.testdatabuilder.AreaTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioEliminarArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarAreaTest {

    @Test
    void verificarAreaExista()
    {
        var area = new AreaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioArea.class);
        var servicio = new ServicioEliminarArea(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Area con los datos ingresados", Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                servicio.ejecutarEliminar(1L)).getMessage());
    }
}
