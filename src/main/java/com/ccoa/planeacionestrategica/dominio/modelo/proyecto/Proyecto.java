package com.ccoa.planeacionestrategica.dominio.modelo.proyecto;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.enums.EModalidad;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
@Setter
@Getter
public class Proyecto {
    private final Long idProyecto;
    private final String nombre;
    private final Double presupuesto;
    private final EModalidad modalidad;
    private final Double valorEjecutado;
    private final Boolean estado;


    public static Proyecto of(Long idProyecto, String nombre, Double presupuesto, EModalidad modalidad, Double valorEjecutado, Boolean estado){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(presupuesto,EL_PRESUPUESTO_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(modalidad,LA_MODALIDAD_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(valorEjecutado,EL_VALOR_EJECUTADO_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        return new Proyecto(idProyecto, nombre, presupuesto, modalidad, valorEjecutado, estado);
    }

    public Proyecto(Long idProyecto, String nombre, Double presupuesto, EModalidad modalidad, Double valorEjecutado, Boolean estado) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.modalidad = modalidad;
        this.valorEjecutado = valorEjecutado;
        this.estado = estado;
    }
}
