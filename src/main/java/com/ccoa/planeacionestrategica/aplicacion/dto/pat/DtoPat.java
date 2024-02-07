package com.ccoa.planeacionestrategica.aplicacion.dto.pat;

import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.aplicacion.dto.proceso.DtoProceso;
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
    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double porcentajeCumplimiento;
    private DtoProceso proceso;
    private DtoDireccion direccion;
    private Long idUsuario;

}
