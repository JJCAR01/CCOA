package com.ccoa.isotools.dominio.servicio.rubroingreso;

import com.ccoa.isotools.dominio.testdatabuilder.AreaTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.RubroIngresoTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioModificarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso.ServicioModificarRubroIngreso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioModificarRubroIngresoTest {

    @Test
    void verifcarNoExisteRubroIngreso() {
        var rubroIngreso = new RubroIngresoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioRubroIngreso.class);
        var servicio = new ServicioModificarRubroIngreso(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Rubro de Ingreso con los datos ingresados", Assertions.assertThrows(IllegalStateException.class,()->
                servicio.ejecutarModificar(rubroIngreso,1L)).getMessage());
    }
}
