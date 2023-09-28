package com.ccoa.planeacionestrategica.dominio.modelo.tarea;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Tarea {

    //Clase de de asignacion de atributos y se validan entradas

    private final Long idTarea;
    private final String nombre;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;
    private final Long idUsuario;
    private final Long idPat;



    public static Tarea of(Long idTarea, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario, Long idPat){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del programa NO debe estar vacío");
        ValidadorDominio.fechaInicioEsMayorActual(fechaInicio,"La fecha de Inicio debe ser mayor a la actual");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"La fecha de inicio del programa NO debe estar vacía");
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicio,"La fecha Final debe ser mayor a la fecha de Inicio");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha final del programa NO debe estar vacía");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha de registro del programa NO debe estar vacía");

        return new Tarea(idTarea, nombre,fechaInicio,fechaFinal,fechaRegistro,idUsuario,idPat);
    }

    public static Tarea listar(Long idTarea, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario, Long idPat) {
        return new Tarea(idTarea, nombre,fechaInicio,fechaFinal,fechaRegistro,idUsuario,idPat);
    }

    public Tarea(Long idTarea, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario, Long idPat) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
        this.idPat = idPat;
    }
}
