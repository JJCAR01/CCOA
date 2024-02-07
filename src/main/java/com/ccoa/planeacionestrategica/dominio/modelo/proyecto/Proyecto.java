package com.ccoa.planeacionestrategica.dominio.modelo.proyecto;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EModalidad;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
@Data
public class Proyecto {
    private final Long idProyecto;
    private final String nombre;
    private final Double presupuesto;
    private final EModalidad modalidad;
    private final Double valorEjecutado;
    private final Long idActividadEstrategica;
    private final Long idUsuario;


    public static Proyecto of(Long idProyecto, String nombre, Double presupuesto, EModalidad modalidad,
                              Double valorEjecutado, Long idActividadEstrategica, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(presupuesto,EL_PRESUPUESTO_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(modalidad,LA_MODALIDAD_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(valorEjecutado,EL_VALOR_EJECUTADO_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(idActividadEstrategica,NO_PUEDE_EXISTIR_SIN_ACTIVIDAD_ESTRATEGICA);
        ValidadorDominio.validarObligatorio(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        return new Proyecto(idProyecto, nombre, presupuesto, modalidad, valorEjecutado, idActividadEstrategica, idUsuario);
    }

    public Proyecto(Long idProyecto, String nombre, Double presupuesto, EModalidad modalidad, Double valorEjecutado, Long idActividadEstrategica, Long idUsuario) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.modalidad = modalidad;
        this.valorEjecutado = valorEjecutado;
        this.idActividadEstrategica = idActividadEstrategica;
        this.idUsuario = idUsuario;
    }
}
