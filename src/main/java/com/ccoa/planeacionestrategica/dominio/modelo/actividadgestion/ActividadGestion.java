package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Data
public class ActividadGestion {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idActividadGestion;
    private final String nombre;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;
    private final Long idUsuario;
    private final Long idPat;

    public static ActividadGestion of(Long idActividadGestion, String nombre, LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario, Long idPat){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DE_LA_ACTIVIDAD_DE_LA_GESTION_DEL_AREA_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validadorMaximo255Caracteres(nombre,EXCEDIO_MAXIMO_DE_CARACTERES);
        ValidadorDominio.validarObligatorioTipoDato(fechaInicial,LA_FECHA_INICIAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,LA_FECHA_FINAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicial,LA_FECHA_FINAL_DEBE_SER_MAYOR_A_LA_FECHA_INICIAL);
        ValidadorDominio.siEsFechaActualRegistrada(fechaRegistro, LA_FECHA_REGISTRO_DEBE_SER_LA_FECHA_ACTUAL);
        ValidadorDominio.validarObjeto(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        ValidadorDominio.validarObjeto(idPat,NO_PUEDE_EXISTIR_SIN_PAT);
        return new ActividadGestion(idActividadGestion, nombre, fechaInicial, fechaFinal, fechaRegistro, idUsuario, idPat);
    }

    public ActividadGestion(Long idActividadGestion, String nombre, LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario, Long idPat) {
        this.idActividadGestion = idActividadGestion;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
        this.idPat = idPat;
    }
}
