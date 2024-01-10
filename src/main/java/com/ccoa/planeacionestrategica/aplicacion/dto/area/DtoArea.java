package com.ccoa.planeacionestrategica.aplicacion.dto.area;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoArea {

    private Long idArea;
    private String nombre;
    private Long direccion;
}
