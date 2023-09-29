package com.ccoa.isotools.dominio.servicio.gestion;

import com.ccoa.isotools.dominio.testdatabuilder.GestionTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.gestion.ServicioModificarGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioModificarGestionTest {

    @Test
    void verificarNoExistaGestion()
    {
        var gestion = new GestionTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioGestion.class);
        var servicio = new ServicioModificarGestion(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe la gestion del area con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () -> servicio.ejecutarModificar(gestion,1L)).getMessage());
    }
}
