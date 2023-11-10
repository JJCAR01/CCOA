package com.ccoa.planeacionestrategica.aplicacion.dto.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoRespuesta<T> {

    private T valor;
}
