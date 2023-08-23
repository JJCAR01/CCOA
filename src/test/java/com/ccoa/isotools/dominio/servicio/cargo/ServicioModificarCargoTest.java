package com.ccoa.isotools.dominio.servicio.cargo;

import com.ccoa.isotools.dominio.testdatabuilder.CargoTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioModificarCargo;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioModificarCargoTest {

    @Test
    void verificarNoExistaCargo()
    {
        var cargo = new CargoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioCargo.class);
        var servicio = new ServicioModificarCargo(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Cargo con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () -> servicio.ejecutarModificar(cargo,1L)).getMessage());
    }
}
