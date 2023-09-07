package com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

@Getter
public class DetalleActividadPrincipal {

    private final Long idLineaEstrategica;
    private final Long idUsuario;
    private final Long idTipoGI;

    public static DetalleActividadPrincipal of(Long idLineaEstrategica, Long idUsuario, Long idTipoGI) {
            ValidadorDominio.validadorNumeroLongYMayorACero(idLineaEstrategica, "La linea estrategica NO debe estar vacía");
            ValidadorDominio.validadorNumeroLongYMayorACero(idUsuario, "El usuario NO debe estar vacía");
            ValidadorDominio.validadorNumeroLongYMayorACero(idTipoGI, "El tipo GI NO debe estar vacía");

            return new DetalleActividadPrincipal(idLineaEstrategica,idUsuario,idTipoGI);
    }

    public DetalleActividadPrincipal(Long idLineaEstrategica, Long idUsuario, Long idTipoGI) {
        this.idLineaEstrategica = idLineaEstrategica;
        this.idUsuario = idUsuario;
        this.idTipoGI = idTipoGI;
    }
}
