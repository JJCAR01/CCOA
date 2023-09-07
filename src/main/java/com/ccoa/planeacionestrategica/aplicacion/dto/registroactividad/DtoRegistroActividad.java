package com.ccoa.planeacionestrategica.aplicacion.dto.registroactividad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoRegistroActividad {

    private String comentario;
    private Double porcentaje;
    private LocalDate fechaRegistro;
    private Long idActividadPrincipal;
    private Long idUsuario;

}
