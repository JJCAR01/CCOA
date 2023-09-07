package com.ccoa.isotools.dominio.servicio.pat;

import com.ccoa.isotools.dominio.testdatabuilder.CargoTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.PatTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioEliminarCargo;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioEliminarPat;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarPatTest {

    @Test
    void verificarPatExista()
    {
        var pat = new PatTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioPat.class);
        var servicio = new ServicioEliminarPat(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el PAT con los datos ingresados", Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                servicio.ejecutarEliminar(1L)).getMessage());
    }
}
