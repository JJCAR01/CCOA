package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rol {

    //Clase de de asignacion de atributos y se validan entradas

    private final String rol;


    public static Rol of(String rol){
        ValidadorDominio.validarObligatorio(rol,"El rol NO puede ser vacío");
        return new Rol(rol);
    }


}
