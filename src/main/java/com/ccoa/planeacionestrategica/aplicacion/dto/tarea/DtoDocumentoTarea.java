package com.ccoa.planeacionestrategica.aplicacion.dto.tarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoDocumentoTarea {
    private Long idDocumentoTarea;
    private Long idTarea;
    private String rutaDocumento;
    private LocalDate fecha;
}
