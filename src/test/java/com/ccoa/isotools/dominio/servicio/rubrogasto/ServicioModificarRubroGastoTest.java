package com.ccoa.isotools.dominio.servicio.rubrogasto;

import com.ccoa.isotools.dominio.testdatabuilder.AreaTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.RubroGastoTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioModificarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioEliminarRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioModificarRubroGasto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioModificarRubroGastoTest {
    @Test
    void verifcarNoExisteRubroGasto() {
        var rubroGasto = new RubroGastoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioRubroGasto.class);
        var servicio = new ServicioModificarRubroGasto(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Rubro de Gasto con los datos ingresados", Assertions.assertThrows(IllegalStateException.class,()->
                servicio.ejecutarModificar(rubroGasto,1L)).getMessage());
    }
}
