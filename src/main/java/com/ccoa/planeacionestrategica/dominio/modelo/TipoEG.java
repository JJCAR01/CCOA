package com.ccoa.planeacionestrategica.dominio.modelo;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

@Getter
public class TipoEG {

    //Clase de de asignacion de atributos y se validan entradas

    private final Long idTipoEG;
    private final String nombre;
    public static TipoEG of(Long idTipoEG,String nombre){
        ValidadorDominio.validarObligatorio(nombre,"El nombre del tipo de epica o gestion del rea no debe estar vacía");

        return new TipoEG(idTipoEG, nombre);
    }

    public TipoEG(Long idTipoEG, String nombre) {
        this.idTipoEG = idTipoEG;
        this.nombre = nombre;
    }
}
