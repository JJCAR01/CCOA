package com.ccoa.isotools.dominio.testdatabuilder;

import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;

import java.time.LocalDate;
import java.util.List;

public class PatTestDataBuilder {

    private long idPat;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double cumplimiento;
    private long idUsuario;

    public PatTestDataBuilder() {
        this.idPat = 1;
        this.nombre = "PAT";
        this.fechaInicio = LocalDate.parse("2023-12-10");
        this.fechaFinal = LocalDate.parse("2024-12-10");
        this.fechaRegistro = LocalDate.now();
        this.porcentajeReal = 0.0;
        this.porcentajeEsperado = 0.0;
        this.cumplimiento = 0.0;
        this.idUsuario = 1;
    }

    public Pat build() {
        return Pat.of(idPat,nombre,fechaInicio,fechaFinal,fechaRegistro,porcentajeReal,porcentajeEsperado,cumplimiento,idUsuario);
    }
}
