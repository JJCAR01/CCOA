package com.ccoa.isotools.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorCaracteresExcepcion;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorNombreExcepcion;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorNumeroExcepcion;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CargoTest {

    @Test
    void validarCreacionExitosa() {

        String nombreUsuario = "j.cardona";
        String nombre = "Juan Jose";
        String apellido = "cardona";
        String password = "Colombia22+";
        String correo = "juan@gmail.com";
        long idCargo = 1;
        long idRol = 1;

        Usuario usuario = Usuario.of(nombreUsuario,nombre,apellido,password,correo,idCargo,idRol);

        Assertions.assertEquals("j.cardona", usuario.getNombreUsuario());
        Assertions.assertEquals("Juan Jose",usuario.getNombre());
        Assertions.assertEquals("cardona", usuario.getApellido());
        Assertions.assertEquals("Colombia22+",usuario.getPassword());
        Assertions.assertEquals("juan@gmail.com", usuario.getCorreo());
        Assertions.assertEquals(1,usuario.getIdCargo());
        Assertions.assertEquals(1,usuario.getIdRol());

    }

    @Test
    void validarNombreUsuarioNoCumple() {

        String nombreUsuario = "juann";
        String nombre = "Juan Jose";
        String apellido = "cardona";
        String password = "Colombia22+";
        String correo = "juan@gmail.com";
        long idCargo = 1;
        long idRol = 1;

        Assertions.assertEquals("El nombre de usuario No cuenta con el patrón requerido",Assertions.assertThrows(ValorNombreExcepcion.class, () ->
                Usuario.of(nombreUsuario,nombre,apellido,password,correo,idCargo,idRol)
        ).getMessage());
    }

    @Test
    void validarPasswordNoCumple() {

        String nombreUsuario = "j.cardona";
        String nombre = "Juan Jose";
        String apellido = "cardona";
        String password = "Colombia";
        String correo = "juan@gmail.com";
        long idCargo = 1;
        long idRol = 1;

        Assertions.assertEquals("La contraseña NO cuenta con las ecritura correcta",Assertions.assertThrows(ValorCaracteresExcepcion.class, () ->
                Usuario.of(nombreUsuario,nombre,apellido,password,correo,idCargo,idRol)
        ).getMessage());
    }

    @Test
    void validarCorreoNoCumple() {

        String nombreUsuario = "j.cardona";
        String nombre = "Juan Jose";
        String apellido = "cardona";
        String password = "Colombia22+";
        String correo = "juan@";
        long idCargo = 1;
        long idRol = 1;

        Assertions.assertEquals("El correo NO cuenta con las ecritura correcta",Assertions.assertThrows(ValorCaracteresExcepcion.class, () ->
                Usuario.of(nombreUsuario,nombre,apellido,password,correo,idCargo,idRol)
        ).getMessage());
    }

    @Test
    void validarCamposFaltantesNombre() {

        String nombreUsuario = "j.cardona";
        String nombre = null;
        String apellido = "cardona";
        String password = "Colombia";
        String correo = "juan@gmail.com";
        long idCargo = 1;
        long idRol = 1;

        Assertions.assertEquals("El nombre del usuario NO puede ser vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Usuario.of(nombreUsuario,nombre,apellido,password,correo,idCargo,idRol)
        ).getMessage());
    }

    @Test
    void validarCamposVaciosIdRol() {

        String nombreUsuario = "j.cardona";
        String nombre = "null";
        String apellido = "cardona";
        String password = "Colombia22+";
        String correo = "juan@gmail.com";
        long idCargo = 0;
        long idRol = 1;

        Assertions.assertEquals("El usuario debe tener un rol",Assertions.assertThrows(ValorNumeroExcepcion.class, () ->
                Usuario.of(nombreUsuario,nombre,apellido,password,correo,idCargo,idRol)
        ).getMessage());
    }
}
