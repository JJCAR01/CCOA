package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class LineaEstrategica {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idLineaEstrategica;
    private final String nombre;
    private final String entregable;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;
    private final String indicadorResultado;
    private final Long idPrograma;
    private final Long idUsuario;

    public static LineaEstrategica of(Long idLineaEstrategica,String nombre, String entregable, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro,
                                      String indicadorResultado, Long idPrograma, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,"El nombre de la Linea Estrategica NO debe estar vacío");
        ValidadorDominio.validarObligatorio(entregable,"El entregbable de la linea estatregica NO debe estar vacía");
        ValidadorDominio.fechaInicioEsMayorActual(fechaInicio,"La fecha de Inicio debe ser mayor a la actual");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"La fecha inicial de la linea estatregica NO debe estar vacía");
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicio,"La fecha Final debe ser mayor a la fecha de Inicio");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha final de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha registro de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validarObligatorio(indicadorResultado, "El indicador de resultado de la linea estatregica NO debe estar vacía");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El usuario no puede estra vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idPrograma,"El programa NO debe de estar vacío");
        return new LineaEstrategica(idLineaEstrategica, nombre,entregable,fechaInicio,fechaFinal,fechaRegistro,indicadorResultado
                ,idUsuario,idPrograma);
    }

    public static LineaEstrategica listar(Long idLineaEstrategica,String nombre, String entregable, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro,
                                          String indicadorResultado, Long idPrograma, Long idUsuario){
        return new LineaEstrategica(idLineaEstrategica, nombre,entregable,fechaInicio,fechaFinal,fechaRegistro,indicadorResultado
                ,idUsuario,idPrograma);
    }

    public LineaEstrategica(Long idLineaEstrategica, String nombre, String entregable, LocalDate fechaInicio, LocalDate fechaFinal,
                            LocalDate fechaRegistro, String indicadorResultado, Long idPrograma, Long idUsuario) {
        this.idLineaEstrategica = idLineaEstrategica;
        this.nombre = nombre;
        this.entregable = entregable;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.indicadorResultado = indicadorResultado;
        this.idPrograma = idPrograma;
        this.idUsuario = idUsuario;
    }
}
