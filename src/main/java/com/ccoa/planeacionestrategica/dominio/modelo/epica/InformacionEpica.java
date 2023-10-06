package com.ccoa.planeacionestrategica.dominio.modelo.epica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

@Getter
public class InformacionEpica {

    private final Long idInformacionEpica;
    private final Integer duracion;
    private final Integer diasRestantes;
    private final Boolean estado;
    private final Double avance;

    public static InformacionEpica of(Long idInformacionEpica,Integer duracion, Integer diasRestantes, Boolean estado, Double avance){
        ValidadorDominio.validadorNumeroEnteroYMayorACero(duracion,"El presupuesto de ingreso del programa debe ser mayor a cero y NO puede estar vacío");
        ValidadorDominio.validadorNumeroEnteroYMayorACero(diasRestantes," El presupuesto de gasto del programa debe ser mayor a cero y NO puede estar vacío");

        return new InformacionEpica(idInformacionEpica, duracion, diasRestantes, estado, avance);
    }

    public InformacionEpica(Long idInformacionEpica, Integer duracion, Integer diasRestantes, Boolean estado, Double avance) {
        this.idInformacionEpica = idInformacionEpica;
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.estado = estado;
        this.avance = avance;
    }

}
