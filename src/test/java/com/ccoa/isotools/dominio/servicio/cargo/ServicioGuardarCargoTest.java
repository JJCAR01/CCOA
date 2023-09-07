package com.ccoa.isotools.dominio.servicio.cargo;

import com.ccoa.isotools.dominio.testdatabuilder.CargoTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioGuardarCargo;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarCargoTest {

    @Test
    void siElNombreYaExisteDeberiaRetornarError() {

        //arrange
        var cargo = new CargoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioCargo.class);
        var servicio = new ServicioGuardarCargo(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe el Cargo con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () ->
                        servicio.ejecutarGuardar(cargo)
                ).getMessage());
    }

    @Test
    void guardarExitoso() {

        // arrange
        var cargo = new CargoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioCargo.class);
        var servicio = new ServicioGuardarCargo(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(Cargo.class))).thenReturn(1l);
        // act
        var id = servicio.ejecutarGuardar(cargo);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(cargo);
        Assertions.assertEquals(1l, id);

    }
}
