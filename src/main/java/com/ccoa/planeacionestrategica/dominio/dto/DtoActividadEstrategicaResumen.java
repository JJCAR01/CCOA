package com.ccoa.planeacionestrategica.dominio.dto;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidadMeta;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EUnidad;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoActividadEstrategicaResumen {
    private Long idActividadEstrategica;
    private String nombre;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Integer duracion;
    private Integer diasRestantes;
    private double porcentajeReal;
    private double porcentajeEsperado;
    private double porcentajeCumplimiento;
    private double porcentajePat;
    private EUnidad unidad;
    private Double meta;
    private EPeriodicidadMeta periodicidadMeta;
    private Double resultadoMeta;
    private Double promedioMeta;
    private String entregable;
    private Long idUsuario;
    private Long idPat;


}
