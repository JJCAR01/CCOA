package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidadMeta;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EUnidad;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "detalle_actividades_estrategicas")
public class EntidadDetalleActividadEstrategica {
    @Id
    @Column(name = "id_detalle_actividad_estrategica")
    private Long idDetalleActividadEstrategica;

    @Enumerated(EnumType.STRING)
    private EUnidad unidad;

    private Double meta;
    @Enumerated(EnumType.STRING)
    private EPeriodicidadMeta periodicidadMeta;

    @Column(name = "resultado_meta")
    private Double resultadoMeta;

    @Column(name = "porcentaje_meta")
    private Double porcentajeMeta;

    private String entregable;


    public EntidadDetalleActividadEstrategica(EUnidad unidad, Double meta, EPeriodicidadMeta periodicidadMeta, Double resultadoMeta, Double porcentajeMeta, String entregable) {
        this.unidad = unidad;
        this.meta = meta;
        this.periodicidadMeta = periodicidadMeta;
        this.resultadoMeta = resultadoMeta;
        this.porcentajeMeta = porcentajeMeta;
        this.entregable = entregable;
    }
}
