package com.ccoa.isotools.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoEjecutado {

    private Double valor;
    private String numeroOrden;
    private File documento;
    private DtoActividadPrincipal dtoActividadPrincipal;
    private DtoTipoContrato dtoTipoContrato;
    private DtoUsuario dtoUsuario;

}
