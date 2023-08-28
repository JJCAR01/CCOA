package com.ccoa.isotools.dominio.servicio.usuario;

import com.ccoa.isotools.dominio.testdatabuilder.CargoTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.UsuarioTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioModificarCargo;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioModificarUsuario;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioModificarUsuarioTest {
/*
    @Test
    void verificarNoExistaCargo()
    {
        var usuario = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioModificarUsuario(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Usuario con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () -> servicio.ejecutarModificar(usuario,1L)).getMessage());
    }

 */
}
