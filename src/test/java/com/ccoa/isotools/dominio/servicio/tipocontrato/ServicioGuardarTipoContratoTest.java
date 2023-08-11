package com.ccoa.isotools.dominio.servicio.tipocontrato;

import com.ccoa.isotools.dominio.testdatabuilder.RubroIngresoTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.TipoContratoTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoContrato;
import com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso.ServicioGuardarRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.servicio.tipocontrato.ServicioEliminarTipoContrato;
import com.ccoa.planeacionestrategica.dominio.servicio.tipocontrato.ServicioGuardarTipoContrato;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarTipoContratoTest {

    @Test
    void siElNombreYaExisteDebeRetornarError(){

        var tipoContrato = new TipoContratoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioTipoContrato.class);
        var servicio = new ServicioGuardarTipoContrato(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("Ya existe el Tipo de Contrato con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class,()->
                        servicio.ejecutarGuardar(tipoContrato)).getMessage());

    }

    @Test
    void guardarExitosamente() {

        var tipoContrato = new TipoContratoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioTipoContrato.class);
        var servicio = new ServicioGuardarTipoContrato(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(TipoContrato.class))).thenReturn(1l);

        var id = servicio.ejecutarGuardar(tipoContrato);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(tipoContrato);
        Assertions.assertEquals(1l, id);

    }
}
