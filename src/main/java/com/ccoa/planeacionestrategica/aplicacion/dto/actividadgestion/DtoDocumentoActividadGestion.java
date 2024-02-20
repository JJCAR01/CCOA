package com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoDocumentoActividadGestion {

    private Long idActividadGestion;
    private String rutaDocumento;
    private LocalDate fecha;
}
