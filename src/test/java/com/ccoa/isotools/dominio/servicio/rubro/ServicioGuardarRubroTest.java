package com.ccoa.isotools.dominio.servicio.rubro;

import com.ccoa.isotools.dominio.testdatabuilder.RubroTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubro;
import com.ccoa.planeacionestrategica.dominio.servicio.rubro.ServicioGuardarRubro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarRubroTest {

    @Test
    void siElNombreYaExisteDebeRetornarError(){

        var rubroGasto = new RubroTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioRubro.class);
        var servicio = new ServicioGuardarRubro(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("Ya existe el Rubro de Gasto con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class,()->
                        servicio.ejecutarGuardar(rubroGasto)).getMessage());

    }

    @Test
    void guardarExitosamente() {

        var rubroGasto = new RubroTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioRubro.class);
        var servicio = new ServicioGuardarRubro(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(Rubro.class))).thenReturn(1l);

        var id = servicio.ejecutarGuardar(rubroGasto);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(rubroGasto);
        Assertions.assertEquals(1l, id);

    }
}
