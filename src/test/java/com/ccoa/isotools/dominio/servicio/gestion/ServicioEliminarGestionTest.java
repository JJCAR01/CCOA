package com.ccoa.isotools.dominio.servicio.gestion;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.gestion.ServicioEliminarGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarGestionTest {
    @Test
    void verificarGestionExista()
    {
        var repositorio = Mockito.mock(RepositorioGestion.class);
        var servicio = new ServicioEliminarGestion(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe la Gestion del area con los datos ingresados", Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                servicio.ejecutarEliminar(1L)).getMessage());
    }
}
