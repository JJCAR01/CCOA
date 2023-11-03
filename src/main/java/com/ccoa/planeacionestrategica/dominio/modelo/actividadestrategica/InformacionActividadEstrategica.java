package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
public class InformacionActividadEstrategica {

    private final Integer duracion;
    private final Integer diasRestantes;
    private final Boolean estado;
    private final Double avance;
    private final Long idPat;
    private final Long idUsuario;

    public static InformacionActividadEstrategica of( Integer duracion, Integer diasRestantes, Boolean estado,
                                                     Double avance, Long idPat,Long idUsuario){
        ValidadorDominio.validadorNumeroDoubleYMayorACero(avance,EL_PORCENTAJE_DE_AVANCE_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,NO_PUEDE_EXISTIR_SIN_PAT);
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        return new InformacionActividadEstrategica(duracion, diasRestantes, estado, avance, idPat,idUsuario);
    }

    public InformacionActividadEstrategica( Integer duracion, Integer diasRestantes, Boolean estado, Double avance, Long idPat,Long idUsuario) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.estado = estado;
        this.avance = avance;
        this.idPat = idPat;
        this.idUsuario=idUsuario;
    }

}
