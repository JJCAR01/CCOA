package com.ccoa.isotools.dominio.servicio.usuario;

import com.ccoa.isotools.dominio.testdatabuilder.CargoTestDataBuilder;
import com.ccoa.isotools.dominio.testdatabuilder.UsuarioTestDataBuilder;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioGuardarCargo;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioGuardarUsuario;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorInvalidoExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarUsuarioTest {
/*
    @Test
    void siElNombreYaExisteDeberiaRetornarError() {

        //arrange
        var usuario = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioGuardarUsuario(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe el Usuario con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () ->
                        servicio.ejecutarGuardar(usuario)
                ).getMessage());
    }

    @Test
    void guardarExitoso() {

        // arrange
        var usuario = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioGuardarUsuario(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(Usuario.class))).thenReturn(1l);
        // act
        var id = servicio.ejecutarGuardar(usuario);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(usuario);
        Assertions.assertEquals(1l, id);

    }

 */
}
