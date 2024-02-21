package com.ccoa.planeacionestrategica.dominio.modelo.pat;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Data
public class Pat {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idPat;
    private final String nombre;
    private final Integer fechaAnual;
    private final LocalDate fechaRegistro;
    private final double porcentajePat;
    private final Long idUsuario;

    public static Pat of(Long idPat, String nombre, Integer fechaAnual, LocalDate fechaRegistro, double porcentajePat, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DEL_PAT_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroEnteroYMayorACero(fechaAnual,LA_FECHA_ANUAL_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.siEsFechaActualRegistrada(fechaRegistro,LA_FECHA_REGISTRO_DEBE_SER_LA_FECHA_ACTUAL);
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        return new Pat(idPat, nombre, fechaAnual, fechaRegistro, porcentajePat, idUsuario);
    }

    public Pat(Long idPat, String nombre, Integer fechaAnual, LocalDate fechaRegistro, double porcentajePat, Long idUsuario) {
        this.idPat = idPat;
        this.nombre = nombre;
        this.fechaAnual = fechaAnual;
        this.fechaRegistro = fechaRegistro;
        this.porcentajePat = porcentajePat;
        this.idUsuario = idUsuario;
    }
}
