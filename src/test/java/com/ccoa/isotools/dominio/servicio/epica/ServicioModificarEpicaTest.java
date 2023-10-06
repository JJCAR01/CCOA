package com.ccoa.isotools.dominio.servicio.epica;

import com.ccoa.isotools.dominio.testdatabuilder.tarea.EpicaTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import com.ccoa.planeacionestrategica.dominio.servicio.epica.ServicioModificarEpica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioModificarEpicaTest {
    @Test
    void verificarNoExistaGestion()
    {
        var epica = new EpicaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioEpica.class);
        var servicio = new ServicioModificarEpica(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe la Epica con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () -> servicio.ejecutarModificar(epica,1L)).getMessage());
    }
}
