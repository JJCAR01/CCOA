package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidadMeta;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EUnidad;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
public class DetalleActividadEstrategica {
    private final EUnidad unidad;
    private final Double meta;
    private final EPeriodicidadMeta periodicidadMeta;
    private final Double resultadoMeta;
    private final Double porcentajeMeta;
    private final String entregable;

    public static DetalleActividadEstrategica of(EUnidad unidad, Double meta, EPeriodicidadMeta periodicidadMeta,
                                                 Double resultadoMeta, Double porcentajeMeta, String entregable ){
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(meta,LA_META_NO_PUEDE_SER_NEGATIVA);
        ValidadorDominio.validarObligatorio(entregable,EL_ENTREGABLE_NO_PUEDE_ESTAR_VACIO);
        return new DetalleActividadEstrategica(unidad, meta, periodicidadMeta, resultadoMeta, porcentajeMeta, entregable);
    }
    public static DetalleActividadEstrategica modificarResultadoMeta(EUnidad unidad, Double meta, EPeriodicidadMeta periodicidadMeta,
                                                                     Double resultadoMeta, Double porcentajeMeta, String entregable) {
        ValidadorDominio.validadorNumeroDoubleYMayorOIgualACero(resultadoMeta,EL_RESULTADO_DE_LA_META_NO_PUEDE_SER_NEGATIVA);
        return new DetalleActividadEstrategica(unidad, meta, periodicidadMeta, resultadoMeta, porcentajeMeta, entregable);
    }
    public DetalleActividadEstrategica(EUnidad unidad, Double meta, EPeriodicidadMeta periodicidadMeta, Double resultadoMeta, Double porcentajeMeta, String entregable) {
        this.unidad = unidad;
        this.meta = meta;
        this.periodicidadMeta = periodicidadMeta;
        this.resultadoMeta = resultadoMeta;
        this.porcentajeMeta = porcentajeMeta;
        this.entregable = entregable;
    }
}
