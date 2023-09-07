package com.ccoa.isotools.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorCaracteresExcepcion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PatTest {

    @Test
    void validarCreacionExitosa() {

        long idPat = 1;
        String nombre = "PAT";
        LocalDate fechaInicio = LocalDate.parse("2023-12-10");
        LocalDate fechaFinal = LocalDate.parse("2024-12-10");
        LocalDate fechaRegistro = LocalDate.now();
        Double porcentajeReal = 0.0;
        Double porcentajeEsperado = 0.0;
        Double cumplimiento = 0.0;
        long idUsuario = 1;

        Pat pat = Pat.of(idPat,nombre,fechaInicio,fechaFinal,fechaRegistro,porcentajeReal,porcentajeEsperado,cumplimiento,idUsuario);

        Assertions.assertEquals(1,pat.getIdPat());
        Assertions.assertEquals("PAT",pat.getNombre());
        Assertions.assertEquals(LocalDate.parse("2023-12-10"), pat.getFechaInicio());
        Assertions.assertEquals(LocalDate.parse("2024-12-10"),pat.getFechaFinal());
        Assertions.assertEquals(LocalDate.now(), pat.getFechaRegistro());
        Assertions.assertEquals(0.0, pat.getPorcentajeReal());
        Assertions.assertEquals(0.0, pat.getPorcentajeEsperado());
        Assertions.assertEquals(0.0, pat.getCumplimiento());
        Assertions.assertEquals(1,pat.getIdUsuario());
    }
/*
    @Test
    void validarPasswordNoCumple() {

        long idUsuario = 1;
        String nombre = "Juan Jose";
        String apellido = "cardona";
        String password = "Colombia";
        String correo = "juan@gmail.com";
        long idCargo = 1;
        List<Rol> roles = Arrays.asList(Rol.of(1l,"ADMIN"),Rol.of(2l,"LECTOR"));

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
        List<Rol> roles = Arrays.asList(Rol.of(1l,"ADMIN"),Rol.of(2l,"LECTOR"));

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
        String correo = "juan@gmail.com";
        long idCargo = 1;
        List<Rol> roles = Arrays.asList(Rol.of(1l,"ADMIN"),Rol.of(2l,"LECTOR"));

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
        String correo = "juan@gmail.com";
        long idCargo = 0;
        List<Rol> roles = Arrays.asList(Rol.of(1l,"ADMIN"),Rol.of(2l,"LECTOR"));

        Assertions.assertEquals("El nombre del usuario NO puede ser vacío",Assertions.assertThrows(ValorObligatorioExcepcion.class, () ->
                Usuario.of(idUsuario,nombre,apellido,password,correo,idCargo,roles)
        ).getMessage());
    }

 */
}
