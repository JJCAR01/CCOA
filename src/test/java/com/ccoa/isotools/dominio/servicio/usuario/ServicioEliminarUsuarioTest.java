package com.ccoa.isotools.dominio.servicio.usuario;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioEliminarUsuario;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarUsuarioTest {

    @Test
    void verificarCargoExista()
    {
        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioEliminarUsuario(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Usuario con los datos ingresados", Assertions.assertThrows(ValorObligatorioExcepcion.class, () -> servicio.ejecutarEliminar(1L)).getMessage());
    }

}
