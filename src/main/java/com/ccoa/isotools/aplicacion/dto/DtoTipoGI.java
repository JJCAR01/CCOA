package com.ccoa.isotools.aplicacion.dto;

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
    private Double valorUnitario;
    private Double valorTotal;
    private String observacion;
    private DtoRubroGasto dtoRubroGasto;
    private DtoRubroIngreso dtoRubroIngreso;
}
