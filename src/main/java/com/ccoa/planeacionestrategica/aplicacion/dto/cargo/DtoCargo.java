package com.ccoa.planeacionestrategica.aplicacion.dto.cargo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoCargo {

    private Long idCargo;
    private String nombre;
    private Long idArea;
    
}
