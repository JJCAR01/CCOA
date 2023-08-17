package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.Validador;
import lombok.Getter;

import java.util.Date;

@Getter
public class ImperativoEstrategico {

    //Clase de de asignacion de atributos y se validan entradas

    private final String nombre;
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final Date fechaRegistro;
    private final Pat pat;
    private final Usuario usuario;

    public static ImperativoEstrategico of(String nombre,Date fechaInicio, Date fechaFinal,Date fechaRegistro, Pat pat, Usuario usuario){
        Validador.validarObligatorio(nombre,"El nombre del Imperativo Estraegico NO debe estar vacío");
        Validador.validarObligatorioTipoDato(fechaInicio,"La fecha de inicio del Imperativo estrategico NO debe estar vacía");
        Validador.validarObligatorioTipoDato(fechaFinal,"La fecha final NO del Imperativo estrategico  debe estar vacía");
        Validador.validarObligatorioTipoDato(fechaRegistro,"La fecha de registro  del Imperativo estrategico NO debe estar vacía");
        Validador.validarObjeto(pat, "El Pat NO debe de estar vacío");
        Validador.validarObjeto(usuario, "El Usuario NO debe de estar vacío");
        return new ImperativoEstrategico(nombre,fechaInicio,fechaFinal,fechaRegistro,pat,usuario);
    }

    public ImperativoEstrategico(String nombre, Date fechaInicio, Date fechaFinal, Date fechaRegistro, Pat pat, Usuario usuario) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.pat = pat;
        this.usuario = usuario;
    }
}
