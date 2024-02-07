package com.ccoa.planeacionestrategica.aplicacion.dto.pat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoObservacionPat {
    private Long idObservacionPat;
    private Long idPat;
    private LocalDate fecha;
    private String nombre;
}
