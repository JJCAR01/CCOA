package com.ccoa.planeacionestrategica.dominio.modelo.tarea;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Data
public class Tarea {

    private final Long idTarea;
    private final String nombre;
    private final EEstado estado;
    private final String descripcion;
    private final ETipoASE tipoASE;
    private final Long idASE;
    private final Long idUsuario;

    public static Tarea of(Long idTarea, String nombre, EEstado estado, String observacion, ETipoASE tipoASE, Long idASE, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DE_LA_TAREA_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(estado,EL_ESTADO_DE_LA_TAREA_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        return new Tarea(idTarea, nombre,estado, observacion, tipoASE, idASE, idUsuario);
    }

    public Tarea(Long idTarea, String nombre, EEstado estado, String descripcion, ETipoASE tipoASE, Long idASE, Long idUsuario) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.tipoASE = tipoASE;
        this.idASE = idASE;
        this.idUsuario = idUsuario;
    }
}
