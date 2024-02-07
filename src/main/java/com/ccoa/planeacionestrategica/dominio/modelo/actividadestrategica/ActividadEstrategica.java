package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
public class ActividadEstrategica {

    //Clase de de asignacion de atributos y se validan entradas

    private final Long idActividadEstrategica;
    private final String nombre;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final LocalDate fechaRegistro;
    private final Long idPat;
    private final Long idUsuario;

    public static ActividadEstrategica of(Long idActividadEstrategica, String nombre, LocalDate fechaInicial, LocalDate fechaFinal,
                                          LocalDate fechaRegistro, Long idPat, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DE_LA_ACTIVIDAD_ESTRATEGICA_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validarObligatorioTipoDato(fechaInicial,LA_FECHA_INICIAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,LA_FECHA_FINAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicial,LA_FECHA_FINAL_DEBE_SER_MAYOR_A_LA_FECHA_INICIAL);
        ValidadorDominio.validarObjeto(fechaRegistro,LA_FECHA_REGISTRO_DEBE_SER_LA_FECHA_ACTUAL);
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,NO_PUEDE_EXISTIR_SIN_PAT);
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        return new ActividadEstrategica(idActividadEstrategica, nombre,fechaInicial,fechaFinal,fechaRegistro,idPat,idUsuario);
    }

    public ActividadEstrategica(Long idActividadEstrategica, String nombre, LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaRegistro, Long idPat, Long idUsuario) {
        this.idActividadEstrategica = idActividadEstrategica;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idPat = idPat;
        this.idUsuario = idUsuario;
    }
}
