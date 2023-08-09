package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorArgumento;
import com.ccoa.planeacionestrategica.dominio.validador.ValidadorNumero;
import lombok.Getter;

import java.io.File;
import java.util.Date;

@Getter
public class RegistroActividad {

    //Clase de de asignacion de atributos y se validan entradas

    private final String comentario;
    private final Double porcentaje;
    private final Date fechaRegistro;
    private final File documento;

    public static RegistroActividad of(String comentario,Double porcentaje,Date fechaRegistro,File documento){
        ValidadorArgumento.validarObligatorio(comentario,"El comentario del registro de la actividad no puede ser vacío");
        ValidadorNumero.validadorNumeroDoubleMayorACero(porcentaje,"El porcentaje del registro de la actividad no puede ser vacío o menor a cero");

        return new RegistroActividad(comentario, porcentaje, fechaRegistro, documento);
    }

    public RegistroActividad(String comentario, Double porcentaje, Date fechaRegistro, File documento) {
        this.comentario = comentario;
        this.porcentaje = porcentaje;
        this.fechaRegistro = fechaRegistro;
        this.documento = documento;
    }
}
