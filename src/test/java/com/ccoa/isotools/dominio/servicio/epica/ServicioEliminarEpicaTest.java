package com.ccoa.isotools.dominio.servicio.epica;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import com.ccoa.planeacionestrategica.dominio.servicio.epica.ServicioEliminarEpica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarEpicaTest {
    @Test
    void verificarEpicaExista()
    {
        var repositorio = Mockito.mock(RepositorioEpica.class);
        var servicio = new ServicioEliminarEpica(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe la Epica con los datos ingresados", Assertions.assertThrows(ValorInvalidoExcepcion.class, () ->
                servicio.ejecutarEliminar(1L)).getMessage());
    }
}
