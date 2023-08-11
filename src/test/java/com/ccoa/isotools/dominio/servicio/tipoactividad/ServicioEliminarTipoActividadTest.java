package com.ccoa.isotools.dominio.servicio.tipoactividad;

import com.ccoa.isotools.dominio.testdatabuilder.RubroGastoTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.TipoActividadTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioEliminarRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad.ServicioEliminarTipoActividad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarTipoActividadTest {

    @Test
    void verifcarNoExisteTipoActividad() {
        var tipoActividad = new TipoActividadTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioTipoActividad.class);
        var servicio = new ServicioEliminarTipoActividad(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Tipo de Actividad con los datos ingresados", Assertions.assertThrows(IllegalStateException.class,()->
                servicio.ejecutarEliminar(1L)).getMessage());
    }
}
