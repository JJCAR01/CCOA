package com.ccoa.isotools.dominio.servicio.rubro;

import com.ccoa.isotools.dominio.testdatabuilder.RubroTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubro;
import com.ccoa.planeacionestrategica.dominio.servicio.rubro.ServicioEliminarRubro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarRubroTest {

    @Test
    void verifcarNoExisteRubroGasto() {
        var rubroGasto = new RubroTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioRubro.class);
        var servicio = new ServicioEliminarRubro(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Rubro de Gasto con los datos ingresados", Assertions.assertThrows(IllegalStateException.class,()->
                servicio.ejecutarEliminar(1L)).getMessage());
    }
}
