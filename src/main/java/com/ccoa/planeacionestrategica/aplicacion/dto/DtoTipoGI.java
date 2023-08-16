package com.ccoa.planeacionestrategica.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoTipoGI {

    private Integer cantidad;
    private String clasificacion;
    private Double valorUnitario;
    private Double valorTotal;
    private String observacion;
}
