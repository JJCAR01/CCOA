package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
@Setter
@Getter
public class ActividadGestionActividadEstrategica {

    //Clase de de asignacion de atributos y se validan entradas

    private final Long idActividadGestionActividadEstrategica ;
    private final String nombre;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final Long idUsuario;
    private final Long idActividadEstrategica ;

    public static ActividadGestionActividadEstrategica of(Long idActividadGestionActividadEstrategica, String nombre, LocalDate fechaInicial, LocalDate fechaFinal,
                                                          Long idUsuario, Long idActividadEstrategica){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DE_LA_ACTIVIDAD_DE_LA_GESTION_DEL_AREA_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validarObligatorioTipoDato(fechaInicial,LA_FECHA_INICIAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validarObligatorioTipoDato(fechaFinal,LA_FECHA_FINAL_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicial,LA_FECHA_FINAL_DEBE_SER_MAYOR_A_LA_FECHA_INICIAL);
        ValidadorDominio.validarObjeto(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        ValidadorDominio.validarObjeto(idActividadEstrategica,NO_PUEDE_EXISTIR_SIN_ACTIVIDAD_ESTRATEGICA);
        return new ActividadGestionActividadEstrategica(idActividadGestionActividadEstrategica, nombre, fechaInicial, fechaFinal, idUsuario, idActividadEstrategica);
    }

    public ActividadGestionActividadEstrategica(Long idActividadGestionActividadEstrategica, String nombre, LocalDate fechaInicial,
                                                LocalDate fechaFinal, Long idUsuario, Long idActividadEstrategica) {
        this.idActividadGestionActividadEstrategica = idActividadGestionActividadEstrategica;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idUsuario = idUsuario;
        this.idActividadEstrategica = idActividadEstrategica;
    }
}
