package com.ccoa.isotools.dominio.servicio.tipoactividad;

import com.ccoa.isotools.dominio.testdatabuilder.RubroIngresoTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.TipoActividadTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso.ServicioModificarRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad.ServicioEliminarTipoActividad;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad.ServicioModificarTipoActividad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioModificarTipoActividadTest {

    @Test
    void verifcarNoExisteTipoActividad() {
        var tipoActividad = new TipoActividadTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioTipoActividad.class);
        var servicio = new ServicioModificarTipoActividad(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Tipo de Actividad con los datos ingresados", Assertions.assertThrows(IllegalStateException.class,()->
                servicio.ejecutarModificar(tipoActividad,1L)).getMessage());
    }
}
