package com.ccoa.planeacionestrategica.dominio.modelo.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
public class Pat {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idPat;
    private final String nombre;
    private final Integer fechaAnual;
    private final LocalDate fechaRegistro;
    private final Double porcentaje;
    private final EProceso proceso;
    private final Long idUsuario;

    public static Pat of(Long idPat,String nombre,Integer fechaAnual,LocalDate fechaRegistro,
                         Double porcentaje,EProceso proceso, Long idUsuario ){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DEL_PAT_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroEnteroYMayorACero(fechaAnual,LA_FECHA_ANUAL_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.siEsFechaActualRegistrada(fechaRegistro,LA_FECHA_REGISTRO_DEBE_SER_LA_FECHA_ACTUAL);
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(porcentaje,EL_PORCENTAJE_DE_AVANCE_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(proceso,EL_PROCESO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        return new Pat(idPat, nombre,fechaAnual, fechaRegistro,porcentaje,proceso,idUsuario);
    }


    public Pat(Long idPat, String nombre, Integer fechaAnual, LocalDate fechaRegistro, Double porcentaje, EProceso proceso, Long idUsuario) {
        this.idPat = idPat;
        this.nombre = nombre;
        this.fechaAnual = fechaAnual;
        this.fechaRegistro = fechaRegistro;
        this.porcentaje = porcentaje;
        this.proceso = proceso;
        this.idUsuario = idUsuario;
    }
}
