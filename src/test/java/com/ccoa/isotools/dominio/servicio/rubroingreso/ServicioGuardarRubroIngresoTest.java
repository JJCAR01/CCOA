package com.ccoa.isotools.dominio.servicio.rubroingreso;

import com.ccoa.isotools.dominio.testdatabuilder.RubroGastoTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.RubroIngresoTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioGuardarRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso.ServicioEliminarRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso.ServicioGuardarRubroIngreso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarRubroIngresoTest {

    @Test
    void siElNombreYaExisteDebeRetornarError(){

        var rubroIngreso = new RubroIngresoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioRubroIngreso.class);
        var servicio = new ServicioGuardarRubroIngreso(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("Ya existe el Rubro de Ingreso con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class,()->
                        servicio.ejecutarGuardar(rubroIngreso)).getMessage());

    }

    @Test
    void guardarExitosamente() {

        var rubroIngreso = new RubroIngresoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioRubroIngreso.class);
        var servicio = new ServicioGuardarRubroIngreso(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(RubroIngreso.class))).thenReturn(1l);

        var id = servicio.ejecutarGuardar(rubroIngreso);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(rubroIngreso);
        Assertions.assertEquals(1l, id);

    }
}
