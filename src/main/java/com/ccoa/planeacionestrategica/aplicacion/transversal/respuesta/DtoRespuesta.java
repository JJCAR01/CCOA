package com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoRespuesta<T> {

    private T valor;
}
