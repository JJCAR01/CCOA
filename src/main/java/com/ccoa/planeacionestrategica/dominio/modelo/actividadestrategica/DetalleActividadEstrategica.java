package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
public class DetalleActividadEstrategica {
    private final Double meta;
    private final Double resultadoMeta;
    private final Double porcentajeMeta;
    private final String entregable;

    public static DetalleActividadEstrategica of(Double meta, Double resultadoMeta, Double porcentajeMeta, String entregable) {
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(meta,LA_META_NO_PUEDE_SER_NEGATIVA);
        //
        return new DetalleActividadEstrategica(meta, resultadoMeta, porcentajeMeta, entregable);
    }
    public static DetalleActividadEstrategica modificarEntregable(Double meta, Double resultadoMeta, Double porcentajeMeta, String entregable) {
        return new DetalleActividadEstrategica(meta, resultadoMeta, porcentajeMeta, entregable);
    }
    public static DetalleActividadEstrategica modificarResultadometa(Double meta, Double resultadoMeta, Double porcentajeMeta, String entregable) {
        //ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(resultadoMeta,EL_RESULTADO_DE_LA_META_NO_PUEDE_SER_NEGATIVA);
        return new DetalleActividadEstrategica(meta, resultadoMeta, porcentajeMeta, entregable);
    }
    public DetalleActividadEstrategica(Double meta, Double resultadoMeta, Double porcentajeMeta, String entregable) {
        this.meta = meta;
        this.resultadoMeta = resultadoMeta;
        this.porcentajeMeta = porcentajeMeta;
        this.entregable = entregable;
    }
}
