package com.ccoa.planeacionestrategica.dominio.modelo.programa;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

@Getter
public class DetallePrograma {

    private final Long idImperativoEstrategico;
    private final Long idUsuario;
    private final Long idArea;

    public static DetallePrograma of(Long idImperativoEstrategico, Long idUsuario, Long idArea){
        ValidadorDominio.validadorNumeroLongYMayorACero(idImperativoEstrategico,"El imperativo estragico NO debe estar vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario,"El usuario NO debe estar vacío");
        ValidadorDominio.validadorNumeroLongYMayorACero(idArea,"El area NO debe estar vacío");
        return new DetallePrograma(idImperativoEstrategico,idUsuario,idArea);
    }

    public DetallePrograma(Long idImperativoEstrategico, Long idUsuario, Long idArea) {
        this.idImperativoEstrategico = idImperativoEstrategico;
        this.idUsuario = idUsuario;
        this.idArea = idArea;
    }
}
