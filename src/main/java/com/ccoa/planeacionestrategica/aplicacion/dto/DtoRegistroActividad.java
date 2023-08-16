package com.ccoa.planeacionestrategica.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoRegistroActividad {

    private String comentario;
    private Double porcentaje;
    private Date fechaRegistro;
    private String documento;
    private DtoActividadPrincipal dtoActividadPrincipal;
    private DtoUsuario dtoUsuario;

}
