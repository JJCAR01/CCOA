package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;

import java.util.Date;

public class PatTestDataBuilder {

    private String nombre;
    private Date fechaInicio;
    private Date fechaFinal;
    private Date fechaRegistro;

    public PatTestDataBuilder() {

        this.nombre = "nombre";
        this.fechaInicio = new Date(2020,8,20);
        this.fechaFinal = new Date(2020,8,30);
        this.fechaRegistro = new Date(2020,8,15);
    }

    public PatTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PatTestDataBuilder conFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public PatTestDataBuilder conFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
        return this;
    }
    public PatTestDataBuilder conFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
        return this;
    }

}
