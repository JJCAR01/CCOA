package com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoDocumentoProyectoArea {
    private Long idDocumentoProyectoArea;
    private Long idProyectoArea;
    private String rutaDocumento;
    private LocalDate fecha;
}
