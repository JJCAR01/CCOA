package com.ccoa.planeacionestrategica.dominio.modelo.tarea;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
@Setter
public class Tarea {

    private final Long idTarea;
    private final String nombre;
    private final EEstado estado;
    private final String observacion;
    private final ETipoASE tipoASE;
    private final Long idASE;
    private final Long idUsuario;

    public static Tarea of(Long idTarea, String nombre, EEstado estado, String observacion, ETipoASE tipoASE, Long idASE, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DE_LA_TAREA_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(estado,EL_ESTADO_DE_LA_TAREA_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        return new Tarea(idTarea, nombre,estado, observacion, tipoASE, idASE, idUsuario);
    }

    public Tarea(Long idTarea, String nombre, EEstado estado, String observacion, ETipoASE tipoASE, Long idASE, Long idUsuario) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.estado = estado;
        this.observacion = observacion;
        this.tipoASE = tipoASE;
        this.idASE = idASE;
        this.idUsuario = idUsuario;
    }
}
