package com.ccoa.planeacionestrategica.dominio.dto.ids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoIdsProyecto {
    private Long idProyecto;
    private Long idActividadEstrategica;
    private Long idInformacionProyecto;
    private Long idDetalleProyecto;
}
