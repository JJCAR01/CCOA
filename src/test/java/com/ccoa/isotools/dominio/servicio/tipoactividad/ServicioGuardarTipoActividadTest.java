package com.ccoa.isotools.dominio.servicio.tipoactividad;

import com.ccoa.isotools.dominio.testdatabuilder.RubroIngresoTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.TipoActividadTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso.ServicioGuardarRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad.ServicioEliminarTipoActividad;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad.ServicioGuardarTipoActvidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarTipoActividadTest {

    @Test
    void siElNombreYaExisteDebeRetornarError(){

        var tipoActividad = new TipoActividadTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioTipoActividad.class);
        var servicio = new ServicioGuardarTipoActvidad(repositorio);


        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("Ya existe el Tipo de Actividad con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class,()->
                        servicio.ejecutarGuardar(tipoActividad)).getMessage());

    }

    @Test
    void guardarExitosamente() {

        var tipoActividad = new TipoActividadTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioTipoActividad.class);
        var servicio = new ServicioGuardarTipoActvidad(repositorio);


        Mockito.when(repositorio.guardar(Mockito.any(TipoActividad.class))).thenReturn(1l);

        var id = servicio.ejecutarGuardar(tipoActividad);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(tipoActividad);
        Assertions.assertEquals(1l, id);

    }
}
