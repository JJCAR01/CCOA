package com.ccoa.planeacionestrategica.aplicacion.dto.programa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoPrograma {

    private String nombre;
    private String codigo;
    private Integer version;
    private Date fechaInicio;
    private Date fechaFinal;
    private LocalDateTime fechaRegistro;
    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double cumplimiento;
    private Double presupuestoIngreso;
    private Double presupuestoGasto;
    private Long idImperativoEstrategico;
    private Long idUsuario;
    private Long idArea;

}
