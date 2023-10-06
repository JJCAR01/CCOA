package com.ccoa.planeacionestrategica.dominio.transversal.validador;

import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ValidadorDominio {

    private ValidadorDominio() {
    }

    private static final String PATRON_CLAVE = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,15}";
    private static final String PATRON_CORREO = "^[a-zA-Z]+@ccoa\\.org\\.co$";

    private static final String CAMPO_OBLIGATORIO = "El campo %s es obligatorio.";
    public static final String MENSAJE_DEFECTO = "Ocurrió un error procesando la solicitud. Por favor contacta al administrador del sistema.";


    public static void validarObligatorio(Object valor, String mensajeTecnico,String mensajeHumano) {
        if (valor == null || (valor instanceof String str && str.trim().isEmpty())) {
            throw new ValorObligatorioExcepcion(mensajeTecnico, mensajeHumano);
        }
    }

    public static void validarObligatorio(Object valor, String mensajeTecnico) {
        if (valor == null || (valor instanceof String str && str.trim().isEmpty())) {
            throw new ValorObligatorioExcepcion(mensajeTecnico, CAMPO_OBLIGATORIO);
        }
    }

    public static void validarObligatorioTipoDato(LocalDate valor, String mensajeTecnico) {
        if(valor == null) {
            throw new ValorObligatorioExcepcion(mensajeTecnico,MENSAJE_DEFECTO);
        }
    }


    public static void validadorNoVacio(List<? extends Object> lista, String mensajeTecnico) {
        if(lista == null  || lista.isEmpty()) {
            throw new ValorObligatorioExcepcion(mensajeTecnico,MENSAJE_DEFECTO);
        }
    }
    public static void longitudPassword(String valor, String mensaje)
    {
        if(!(valor.length()>=8 && valor.length()<=15))
        {
            throw new LongitudMaxExcepcion(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void validadorNumeroEnteroYMayorACero(Integer valor, String mensaje){

        if((valor <= 0) || (valor == null)){
            throw new ValorNumeroExcepcion(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void validadorNumeroDoubleYMayorACero(Double valor, String mensaje) {

        if((valor <= 0) || (valor == null)){
            throw new ValorNumeroExcepcion(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void validadorNumeroDoubleYMayorOIgualACero(Double valor, String mensaje) {

        if((valor < 0) || (valor == null)){
            throw new ValorNumeroExcepcion(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void validadorNumeroLongYMayorACero(Long valor, String mensaje) {

        if((valor < 0) || (valor == null)){
            throw new ValorNumeroExcepcion(mensaje,MENSAJE_DEFECTO);
        }
    }
    public static void validarObjeto(Object objeto, String mensaje){
        if(objeto == null){
            throw new ValorObjetoExcepcion(mensaje,MENSAJE_DEFECTO);
        }
    }


    public static boolean aceptacionPatron(String cadena, String patron)
    {
        return cadena.matches(patron);
    }

    public static void validadorCaracteresEspecialesPassword(String password, String mensaje)
    {
        if(!aceptacionPatron(password, PATRON_CLAVE))
        {
            throw new ValorCaracteresExcepcion(mensaje,MENSAJE_DEFECTO);
        }
        else{
            longitudPassword(password, "Valor del tamaño excedido");
        }
    }

    public static void validadorCaracteresEspecialesCorreo(String correo, String mensaje)
    {
        if(!aceptacionPatron(correo, PATRON_CORREO))
        {
            throw new ValorCaracteresExcepcion(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void validadorIgual(Object value, Object unexpectedValue, String technicalMessage, String humanMessage) {
        if (unexpectedValue.equals(value)) {
            throw new ValorInvalidoExcepcion(technicalMessage, humanMessage);
        }
    }

    public static void fechaInicioEsMayorActual(LocalDate fecha, String mensaje){
        LocalDate fechaActual =LocalDate.now();
        if(fecha.isBefore(fechaActual)){
            throw new ValidadorFecha(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void fechaFinalEsMayorFechaInicio(LocalDate fechaFinal,LocalDate fechaInicio,String mensaje){
        if(fechaFinal.isBefore(fechaInicio)){
            throw new ValidadorFecha(mensaje,MENSAJE_DEFECTO);
        }
    }
    public static void siEsFechaActualRegistrada(LocalDate fecha,String mensaje){
        LocalDate  fechaActual = LocalDate.now();
        if(!Objects.equals(fecha, fechaActual)){
            throw new ValidadorFecha(mensaje,MENSAJE_DEFECTO);
        }
    }

}
