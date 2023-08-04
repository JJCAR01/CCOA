package com.ccoa.isotools.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.sql.Blob;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoRegistroActividad {

    private String comentario;
    private Double porcentaje;
    private Date fechaRegistro;
    private File documento;
    private DtoActividadPrincipal dtoActividadPrincipal;
    private DtoUsuario dtoUsuario;

}
