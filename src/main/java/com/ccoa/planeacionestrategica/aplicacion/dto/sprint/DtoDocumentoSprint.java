package com.ccoa.planeacionestrategica.aplicacion.dto.sprint;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoDocumentoSprint {
    private Long idDocumentoSprint;
    private Long idSprint;
    private String rutaDocumento;
    private LocalDate fecha;
}
