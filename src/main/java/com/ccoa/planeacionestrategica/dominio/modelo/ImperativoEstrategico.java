package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class ImperativoEstrategico {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idImperativoEstrategico;
    private final String nombre;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;
    private final Double porcentajeReal;
    private final Double porcentajeEsperado;
    private final Double cumplimiento;
    private final Long idPat;
    private final Long idUsuario;

    public static ImperativoEstrategico of(Long idImperativoEstrategico,String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro,
                                           Double porcentajeReal,Double porcentajeEsperado,Double cumplimiento,Long idPat, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del Imperativo Estraegico NO debe estar vacío");
        ValidadorDominio.fechaInicioEsMayorActual(fechaInicio,"La fecha de Inicio debe ser mayor a la actual");
        ValidadorDominio.validarObligatorioTipoDato(fechaInicio,"La fecha de inicio del Imperativo estrategico NO debe estar vacía");
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicio,"La fecha Final debe ser mayor a la fecha de Inicio");
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,"La fecha final NO del Imperativo estrategico  debe estar vacía");
        ValidadorDominio.validarObjeto(fechaRegistro,"La fecha de registro  del Imperativo estrategico NO debe estar vacía");
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeReal,"Porcentaje real null o es menor a 0");
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentajeEsperado,"Porcentaje esperado null o es menor a 0");
        ValidadorDominio.validarObjeto(idPat, "El Pat NO debe de estar vacío");
        ValidadorDominio.validarObjeto(idUsuario, "El Usuario NO debe de estar vacío");
        return new ImperativoEstrategico(idImperativoEstrategico, nombre,fechaInicio,fechaFinal,fechaRegistro,porcentajeReal,porcentajeEsperado,cumplimiento,idPat,idUsuario);
    }

    public static ImperativoEstrategico listar(Long idImperativoEstrategico,String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro,
                                               Double porcentajeReal,Double porcentajeEsperado,Double cumplimiento,Long idPat, Long idUsuario){
        return new ImperativoEstrategico(idImperativoEstrategico, nombre,fechaInicio,fechaFinal,fechaRegistro,porcentajeReal,porcentajeEsperado,cumplimiento,idPat,idUsuario);
    }

    public ImperativoEstrategico(Long idImperativoEstrategico, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Double porcentajeReal,
                                 Double porcentajeEsperado, Double cumplimiento, Long idPat, Long idUsuario) {
        this.idImperativoEstrategico = idImperativoEstrategico;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.cumplimiento = cumplimiento;
        this.idPat = idPat;
        this.idUsuario = idUsuario;
    }
}
