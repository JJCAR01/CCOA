package com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EModalidad;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Data
public class ProyectoArea {
    private final Long idProyectoArea;
    private final String nombre;
    private final Double presupuesto;
    private final EModalidad modalidad;
    private final Double valorEjecutado;
    private final Long idPat;
    private final Long idUsuario;


    public static ProyectoArea of(Long idProyectoArea, String nombre, Double presupuesto, EModalidad modalidad,
                                  Double valorEjecutado, Long idPat, Long idUsuario){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(presupuesto,EL_PRESUPUESTO_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(modalidad,LA_MODALIDAD_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(valorEjecutado,EL_VALOR_EJECUTADO_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(idPat,NO_PUEDE_EXISTIR_SIN_PAT);
        ValidadorDominio.validarObligatorio(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        return new ProyectoArea(idProyectoArea, nombre, presupuesto, modalidad, valorEjecutado, idPat, idUsuario);
    }
    public static ProyectoArea ofValorEjecutado(Long idProyectoArea, String nombre, Double presupuesto, EModalidad modalidad,
                                                Double valorEjecutado, Long idPat, Long idUsuario){
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(valorEjecutado,EL_VALOR_EJECUTADO_DEL_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        return new ProyectoArea(idProyectoArea, nombre, presupuesto, modalidad, valorEjecutado, idPat, idUsuario);
    }

    public ProyectoArea(Long idProyectoArea, String nombre, Double presupuesto, EModalidad modalidad, Double valorEjecutado, Long idPat, Long idUsuario) {
        this.idProyectoArea = idProyectoArea;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.modalidad = modalidad;
        this.valorEjecutado = valorEjecutado;
        this.idPat = idPat;
        this.idUsuario = idUsuario;
    }
}
