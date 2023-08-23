package com.ccoa.isotools.dominio.servicio.cargo;

import com.ccoa.isotools.dominio.testdatabuilder.AreaTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.CargoTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioEliminarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioEliminarCargo;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarCargoTest {

    @Test
    void verificarCargoExista()
    {
        var cargo = new CargoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioCargo.class);
        var servicio = new ServicioEliminarCargo(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Cargo con los datos ingresados", Assertions.assertThrows(ValorObligatorioExcepcion.class, () -> servicio.ejecutarEliminar(1L)).getMessage());
    }
}
