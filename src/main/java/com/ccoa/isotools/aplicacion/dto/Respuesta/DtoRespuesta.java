package com.ccoa.isotools.aplicacion.dto.Respuesta;


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
