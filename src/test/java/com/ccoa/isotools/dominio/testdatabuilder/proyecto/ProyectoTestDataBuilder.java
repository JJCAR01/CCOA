package com.ccoa.isotools.dominio.testdatabuilder.proyecto;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.enums.EModalidad;

public class ProyectoTestDataBuilder {

    private final long idProyecto;
    private final String nombre;
    private final Double presupuesto;
    private final EModalidad modalidad;
    private final Double valorEjecutado;
    private final Boolean estado;
    private final long idActividadEstrategica;

    public ProyectoTestDataBuilder() {
        this.idProyecto = 1;
        this.nombre ="proyecto test";
        this.presupuesto = 500.000;
        this.modalidad = EModalidad.EXTERNO;
        this.valorEjecutado = 5044.000;
        this.estado = true;
        this.idActividadEstrategica = 1;
    }
}
