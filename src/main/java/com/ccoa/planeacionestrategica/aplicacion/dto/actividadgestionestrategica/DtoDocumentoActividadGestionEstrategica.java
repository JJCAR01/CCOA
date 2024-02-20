package com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoDocumentoActividadGestionEstrategica {
    private Long idActividadGestionEstrategica;
    private String rutaDocumento;
    private LocalDate fecha;
}
