package com.ccoa.planeacionestrategica.dominio.modelo.tarea;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EPeriodicidad;
import com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EL_PORCENTAJE_REAL_NO_PUEDE_ESTAR_VACIO;

@Getter
@Setter
public class InformacionTarea {

    private final Long idInformacionTarea;
    private final EPeriodicidad periodicidad;
    private final Double porcentaje;

    public static InformacionTarea of(Long idInformacionTarea, EPeriodicidad periodicidad, Double porcentaje){
        ValidadorDominio.validarObligatorio(periodicidad, Mensajes.LA_PERIODICIDAD_DE_LA_TAREA_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(porcentaje,EL_PORCENTAJE_REAL_NO_PUEDE_ESTAR_VACIO);
        return new InformacionTarea(idInformacionTarea, periodicidad, porcentaje);
    }

    public InformacionTarea(Long idInformacionTarea, EPeriodicidad periodicidad, Double porcentaje) {
        this.idInformacionTarea = idInformacionTarea;
        this.periodicidad = periodicidad;
        this.porcentaje = porcentaje;
    }
}
