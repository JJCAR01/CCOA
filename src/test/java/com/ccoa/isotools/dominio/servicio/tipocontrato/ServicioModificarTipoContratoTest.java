package com.ccoa.isotools.dominio.servicio.tipocontrato;

import com.ccoa.isotools.dominio.testdatabuilder.TipoContratoTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoContrato;
import com.ccoa.planeacionestrategica.dominio.servicio.tipocontrato.ServicioModificarTipoContrato;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioModificarTipoContratoTest {

    @Test
    void verifcarNoExisteTipoContrato() {
        var tipoContrato = new TipoContratoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioTipoContrato.class);
        var servicio = new ServicioModificarTipoContrato(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Tipo de Contrato con los datos ingresados", Assertions.assertThrows(IllegalStateException.class,()->
                servicio.ejecutarModificar(tipoContrato,1L)).getMessage());
    }
}
