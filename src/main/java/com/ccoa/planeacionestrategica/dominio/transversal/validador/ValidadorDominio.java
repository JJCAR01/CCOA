package com.ccoa.planeacionestrategica.dominio.transversal.validador;

import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
@AllArgsConstructor
public class ValidadorDominio {

    private static final String PATRON_CLAVE = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){13,20}$";
    private static final String PATRON_CORREO = "^[a-zA-Z]+@ccoa\\.org\\.co$";
    private static final String CAMPO_OBLIGATORIO = "El campo es obligatorio.";
    private static final String URL = "^(ftp|http|https):\\/\\/[^ \"]+$";
    public static final String MENSAJE_DEFECTO = "Ocurrió un error procesando la solicitud. Por favor contacta al administrador del sistema.";


    public static void validarObligatorio(Object valor, String mensajeTecnico,String mensajeHumano) {
        if (valor == null || (valor instanceof String str && str.trim().isEmpty())) {
            throw new ExcepcionValidadorObligatorio(mensajeTecnico, mensajeHumano);
        }
    }

    public static void validarObligatorio(Object valor, String mensajeTecnico) {
        if (valor == null || (valor instanceof String str && str.trim().isEmpty())) {
            throw new ExcepcionValidadorObligatorio(mensajeTecnico, CAMPO_OBLIGATORIO);
        }
    }

    public static void validarObligatorioTipoDato(LocalDate valor, String mensajeTecnico) {
        if (valor == null) {
            throw new ExcepcionValidadorObligatorio(mensajeTecnico, MENSAJE_DEFECTO);
        }
    }


    public static void validadorNoVacio(List<?> lista, String mensajeTecnico) {
        if(lista == null  || lista.isEmpty()) {
            throw new ExcepcionValidadorObligatorio(mensajeTecnico,MENSAJE_DEFECTO);
        }
    }
    public static void longitudPassword(String valor, String mensaje)
    {
        if(!(valor.length()>=13 && valor.length()<=20))
        {
            throw new ExcepcionLongitudMaxima(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void validadorNumeroEnteroYMayorACero(Integer valor, String mensaje){

        if(valor <= 0){
            throw new ExcepcionValidadorNumero(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void validadorNumeroDoubleYMayorOIgualACero(Double valor, String mensaje) {

        if(valor < 0){
            throw new ExcepcionValidadorNumero(mensaje,MENSAJE_DEFECTO);
        }
    }
    public static void validadorNumeroDoubleYMayorACero(Double valor, String mensaje) {

        if(valor < 0){
            throw new ExcepcionValidadorNumero(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void validadorNumeroLongYMayorACero(Long valor, String mensaje) {

        if(valor < 0){
            throw new ExcepcionValidadorNumero(mensaje,MENSAJE_DEFECTO);
        }
    }
    public static void validarObjeto(Object objeto, String mensaje){
        if(objeto == null){
            throw new ExcepcionValidadorObjeto(mensaje,MENSAJE_DEFECTO);
        }
    }


    public static boolean aceptacionPatron(String cadena, String patron)
    {
        return !cadena.matches(patron);
    }

    public static void validadorCaracteresEspecialesPassword(String password, String mensaje)
    {
        if(aceptacionPatron(password, PATRON_CLAVE))
        {
            throw new ExcepcionValidadorCaracteres(mensaje,MENSAJE_DEFECTO);
        }
        else{
            longitudPassword(password, "Valor del tamaño excedido");
        }
    }

    public static void validadorCaracteresEspecialesCorreo(String correo, String mensaje)
    {
        if(aceptacionPatron(correo, PATRON_CORREO))
        {
            throw new ExcepcionValidadorCaracteres(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void fechaInicioEsMayorActual(LocalDate fecha, String mensaje){
        LocalDate fechaActual =LocalDate.now();
        if(fecha.isBefore(fechaActual)){
            throw new ExcepcionValidadorFecha(mensaje,MENSAJE_DEFECTO);
        }
    }

    public static void fechaFinalEsMayorFechaInicio(LocalDate fechaFinal,LocalDate fechaInicio,String mensaje){
        if(fechaFinal.isBefore(fechaInicio)){
            throw new ExcepcionValidadorFecha(mensaje,MENSAJE_DEFECTO);
        }
    }
    public static void siEsFechaActualRegistrada(LocalDate fecha,String mensaje){
        LocalDate  fechaActual = LocalDate.now();
        if(!Objects.equals(fecha, fechaActual)){
            throw new ExcepcionValidadorFecha(mensaje,MENSAJE_DEFECTO);
        }
    }
    public static void siEsLasFechasRegistrasdasSonValidasParaSprint(LocalDate fechaInicio,LocalDate fechaFinal,String mensaje) {
        long diferencia = calcularDiferencia(fechaInicio,fechaFinal);
        if ((diferencia <= 7)) {
            throw new ExcepcionValidadorFecha(mensaje, MENSAJE_DEFECTO);
        }
    }

    private static long calcularDiferencia(LocalDate fechaInicial, LocalDate fechaFinal){
        return (ChronoUnit.DAYS.between(fechaInicial, fechaFinal));
    }

    public static void validarPatronURLEsValido(String valor, String mensaje) {
        if (!cadenaURL(valor)) {
            throw new ExcepcionValidadorObjeto(mensaje,MENSAJE_DEFECTO);
        }
    }
    public static boolean cadenaURL(String string) {
        return cadenaAceptaElPatron(string, URL);
    }
    public static boolean cadenaAceptaElPatron(String string, String pattern) {
        return aplicarTrim(string).matches(pattern);
    }
    public static String aplicarTrim(String string) {
        return string.trim();
    }

}
