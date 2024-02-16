package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
public class DetalleActividadEstrategica {
    private final Integer meta;
    private final Integer resultadoMeta;
    private final Integer porcentajeMeta;
    private final String entregable;

    public static DetalleActividadEstrategica of(Integer meta, Integer resultadoMeta, Integer porcentajeMeta, String entregable) {
        ValidadorDominio.validadorNumeroEnteroYMayorACero(meta,LA_META_NO_PUEDE_SER_NEGATIVA);
        ValidadorDominio.validadorNumeroEnteroYMayorACero(resultadoMeta,EL_RESULTADO_DE_LA_META_NO_PUEDE_SER_NEGATIVA);
        return new DetalleActividadEstrategica(meta, resultadoMeta, porcentajeMeta, entregable);
    }
    public static DetalleActividadEstrategica modificarResultado(Integer meta, Integer resultadoMeta, Integer porcentajeMeta, String entregable) {
        return new DetalleActividadEstrategica(meta, resultadoMeta, porcentajeMeta, entregable);
    }
    public DetalleActividadEstrategica(Integer meta, Integer resultadoMeta, Integer porcentajeMeta, String entregable) {
        this.meta = meta;
        this.resultadoMeta = resultadoMeta;
        this.porcentajeMeta = porcentajeMeta;
        this.entregable = entregable;
    }
}
