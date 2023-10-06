package com.ccoa.planeacionestrategica.dominio.modelo.actividad;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InformacionActividad {
    private final Long idInformacionActividad;
    private final Integer duracion;
    private final Integer diasRestantes;
    private final Double avance;
    private final Long idEpica;
    private final Long idGestion;

    public static InformacionActividad of(Long idInformacionActividad, Integer duracion, Integer diasRestantes, Double avance, Long idEpica, Long idGestion ){
        ValidadorDominio.validadorNumeroEnteroYMayorACero(duracion,"La duración NO puede estar vacío");
        ValidadorDominio.validadorNumeroEnteroYMayorACero(diasRestantes,"El dato fecha de inicio NO puede estar vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idEpica,"El usuario No puede ser vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idGestion,"El usuario No puede ser vacío");
        return new InformacionActividad(idInformacionActividad, duracion,diasRestantes,avance,idEpica,idGestion);
    }

    public InformacionActividad(Long idInformacionActividad, Integer duracion, Integer diasRestantes, Double avance, Long idEpica, Long idGestion) {
        this.idInformacionActividad = idInformacionActividad;
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.avance = avance;
        this.idEpica = idEpica;
        this.idGestion = idGestion;
    }
}
