package com.ccoa.isotools.dominio.servicio.rubrogasto;

import com.ccoa.isotools.dominio.testdatabuilder.RubroGastoTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioEliminarRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioGuardarRubroGasto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarRubroGastoTest {

    @Test
    void siElNombreYaExisteDebeRetornarError(){

        var rubroGasto = new RubroGastoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioRubroGasto.class);
        var servicio = new ServicioGuardarRubroGasto(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("Ya existe el Rubro de Gasto con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class,()->
                        servicio.ejecutarGuardar(rubroGasto)).getMessage());

    }

    @Test
    void guardarExitosamente() {

        var rubroGasto = new RubroGastoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioRubroGasto.class);
        var servicio = new ServicioGuardarRubroGasto(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(RubroGasto.class))).thenReturn(1l);

        var id = servicio.ejecutarGuardar(rubroGasto);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(rubroGasto);
        Assertions.assertEquals(1l, id);

    }
}
