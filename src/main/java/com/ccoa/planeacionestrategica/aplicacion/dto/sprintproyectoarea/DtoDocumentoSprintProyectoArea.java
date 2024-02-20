package com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoDocumentoSprintProyectoArea {
    private Long idSprintProyectoArea;
    private String rutaDocumento;
    private LocalDate fecha;
}
