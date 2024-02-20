package com.ccoa.planeacionestrategica.aplicacion.dto.proyecto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoDocumentoProyecto {
    private Long idProyecto;
    private String rutaDocumento;
    private LocalDate fecha;
}
