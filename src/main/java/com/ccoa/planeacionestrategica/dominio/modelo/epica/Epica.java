package com.ccoa.planeacionestrategica.dominio.modelo.epica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Epica {

    //Clase de de asignacion de atributos y se validan entradas

    private final Long idEpica;
    private final String nombre;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;
    private final Long idUsuario;



    public static Epica of(Long idEpica,String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del programa NO debe estar vacío");
        ValidadorDominio.fechaInicioEsMayorActual(fechaInicio,"La fecha de Inicio debe ser mayor a la actual");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"La fecha de inicio del programa NO debe estar vacía");
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicio,"La fecha Final debe ser mayor a la fecha de Inicio");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha final del programa NO debe estar vacía");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha de registro del programa NO debe estar vacía");

        return new Epica(idEpica, nombre,fechaInicio,fechaFinal,fechaRegistro,idUsuario);
    }

    public static Epica listar(Long idEpica,String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario) {
        return new Epica(idEpica, nombre,fechaInicio,fechaFinal,fechaRegistro,idUsuario);
    }
    public Epica(Long idEpica, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario) {
        this.idEpica = idEpica;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
    }

}
