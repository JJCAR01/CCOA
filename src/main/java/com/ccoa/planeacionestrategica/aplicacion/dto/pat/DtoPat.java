package com.ccoa.planeacionestrategica.aplicacion.dto.pat;

import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoPat {

    private Long idPat;
    private String nombre;
    private Integer fechaAnual;
    private LocalDate fechaRegistro;
    private Double porcentajePat;
    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double porcentajeCumplimiento;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private boolean estrategica;
    private boolean deProceso;
    private DtoDireccion direccion;
    private Long idUsuario;
    private Long idClasificacion;
}
