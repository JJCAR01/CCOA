package com.ccoa.isotools.dominio.servicio.rubroingreso;

import com.ccoa.isotools.dominio.testdatabuilder.RubroGastoTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.RubroIngresoTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioEliminarRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso.ServicioEliminarRubroIngreso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarRubroIngresoTest {

    @Test
    void verifcarNoExisteRubroIngreso() {
        var rubroIngreso = new RubroIngresoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioRubroIngreso.class);
        var servicio = new ServicioEliminarRubroIngreso(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Rubro de Ingresos con los datos ingresados", Assertions.assertThrows(IllegalStateException.class,()->
                servicio.ejecutarEliminar(1L)).getMessage());
    }
}
