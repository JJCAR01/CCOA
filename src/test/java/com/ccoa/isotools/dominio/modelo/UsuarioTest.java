package com.ccoa.isotools.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorCaracteresExcepcion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UsuarioTest {


    @Test
    void validarCreacionExitosa() {

        long idUsuario = 1;
        String nombre = "Juan Jose";
        String apellido = "cardona";
        String password = "Colombia22+";
        String correo = "juan@ccoa.org.co";
        long idCargo = 1;
        List<Rol> roles = Arrays.asList(Rol.of(1L,"ADMIN"),Rol.of(2L,"LECTOR"));

        Usuario usuario = Usuario.of(idUsuario, nombre,apellido,password,correo,idCargo,roles);

        Assertions.assertEquals("Juan Jose",usuario.getNombre());
        Assertions.assertEquals("cardona", usuario.getApellido());
        Assertions.assertEquals("Colombia22+",usuario.getPassword());
        Assertions.assertEquals("juan@ccoa.org.co", usuario.getCorreo());
        Assertions.assertEquals(1,usuario.getIdCargo());
    }

    @Test
    void validarPasswordNoCumple() {

        long idUsuario = 1;
        String nombre = "Juan Jose";
        String apellido = "cardona";
        String password = "Colombia";
        String correo = "juan@ccoa.org.co";
        long idCargo = 1;
        List<Rol> roles = Arrays.asList(Rol.of(1L,"ADMIN"),Rol.of(2L,"LECTOR"));

        Assertions.assertEquals("La contraseña NO cuenta con las ecritura correcta",Assertions.assertThrows(ValorCaracteresExcepcion.class, () ->
                Usuario.of(idUsuario, nombre,apellido,password,correo,idCargo,roles)
        ).getMessage());
    }

    @Test
    void validarCorreoNoCumple() {

        long idUsuario = 1;
        String nombre = "Juan Jose";
        String apellido = "cardona";
        String password = "Colombia22+";
        String correo = "juan@";
        long idCargo = 1;
        List<Rol> roles = Arrays.asList(Rol.of(1L,"ADMIN"),Rol.of(2L,"LECTOR"));

        Assertions.assertEquals("El correo NO cuenta con las ecritura correcta",Assertions.assertThrows(ValorCaracteresExcepcion.class, () ->
                Usuario.of(idUsuario,nombre,apellido,password,correo,idCargo,roles)
        ).getMessage());
    }

    @Test
    void validarCamposFaltantesNombre() {

        long idUsuario = 1;
        String nombre = null;
        String apellido = "cardona";
        String password = "Colombia";
        String correo = "juan@ccoa.org.co";
        long idCargo = 1;
        List<Rol> roles = Arrays.asList(Rol.of(1L,"ADMIN"),Rol.of(2L,"LECTOR"));

        Assertions.assertEquals("El nombre del usuario NO puede ser vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Usuario.of(idUsuario,nombre,apellido,password,correo,idCargo,roles)
        ).getMessage());
    }

    @Test
    void validarCamposVaciosIdRol() {

        long idUsuario = 1;
        String nombre = "";
        String apellido = "cardona";
        String password = "Colombia22+";
        String correo = "juan@ccoa.org.co";
        long idCargo = 0;
        List<Rol> roles = Arrays.asList(Rol.of(1L,"ADMIN"),Rol.of(2L,"LECTOR"));

        Assertions.assertEquals("El nombre del usuario NO puede ser vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Usuario.of(idUsuario,nombre,apellido,password,correo,idCargo,roles)
        ).getMessage());
    }

}