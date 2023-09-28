package com.ccoa.planeacionestrategica.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoEjecutado {

    private Double valor;
    private String tipoContrato;
    private String numeroOrden;
    private String documento;
    private Long idActividadPrincipal;
    private Long idUsuario;

}
