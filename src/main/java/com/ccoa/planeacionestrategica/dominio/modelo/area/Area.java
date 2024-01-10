package com.ccoa.planeacionestrategica.dominio.modelo.area;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_DIRECCION_NO_PUEDE_ESTAR_VACIA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NOMBRE_DEL_AREA_NO_PUEDE_ESTAR_VACIO;

@Getter
public class Area {

    //Clase de de asignacion de atributos y se validan entradas
    private final Long idArea;
    private final String nombre;
    private final Long idDireccion;

    public static Area of(Long idArea,String nombre, Long idDireccion){
        ValidadorDominio.validarObligatorio(nombre,NOMBRE_DEL_AREA_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarObligatorio(idDireccion,LA_DIRECCION_NO_PUEDE_ESTAR_VACIA);
        return new Area(idArea, nombre, idDireccion);
    }

    public Area(Long idArea, String nombre, Long idDireccion) {
        this.idArea = idArea;
        this.nombre = nombre;
        this.idDireccion = idDireccion;
    }
}
