package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.enums.EProceso;

import java.time.LocalDate;

public class PatTestDataBuilder {

    private long idPat;
    private String nombre;
    private Integer fechaAnual;
    private LocalDate fechaRegistro;
    private Double porcentaje;
    private String proceso;
    private long idUsuario;

    public PatTestDataBuilder() {
        this.idPat = 1;
        this.nombre = "PAT";
        this.fechaAnual = 2023;
        this.fechaRegistro = LocalDate.now();
        this.porcentaje = 0.0;
        this.proceso = "SERVICIOS_TI";
        this.idUsuario = 1;
    }

    public Pat build() {
        return Pat.of(idPat,nombre,fechaAnual,fechaRegistro,porcentaje, EProceso.valueOf(proceso),idUsuario);
    }
}
