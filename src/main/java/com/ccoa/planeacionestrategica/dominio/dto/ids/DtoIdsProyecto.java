package com.ccoa.planeacionestrategica.dominio.dto.ids;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoIdsProyecto {
    private Long idProyecto;
    private Long idActividadEstrategica;
    private Long idInformacionProyecto;
    private Long idDetalleProyecto;
}
