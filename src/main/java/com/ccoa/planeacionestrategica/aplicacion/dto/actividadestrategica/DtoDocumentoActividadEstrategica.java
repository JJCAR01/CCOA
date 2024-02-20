package com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoDocumentoActividadEstrategica {
    private Long idActividadEstrategica;
    private String rutaDocumento;
    private LocalDate fecha;
}
