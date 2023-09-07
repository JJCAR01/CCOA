package com.ccoa.isotools.dominio.servicio.pat;

import com.ccoa.isotools.dominio.testdatabuilder.CargoTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.PatTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioModificarCargo;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioModificarPat;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioModificarPatTest {

    @Test
    void verificarNoExistaPat()
    {
        var pat = new PatTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioPat.class);
        var servicio = new ServicioModificarPat(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el PAT con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () -> servicio.ejecutarModificar(pat,1L)).getMessage());
    }
}
