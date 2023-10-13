package com.ccoa.planeacionestrategica.dominio.dto;

import java.time.LocalDate;

public class DtoSprintResumen {
    private Long idSprint;
    private String descripcion;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Double avance;
    private Boolean estado;
    private Long idProyecto;
    private String rutaArchivo;
}
