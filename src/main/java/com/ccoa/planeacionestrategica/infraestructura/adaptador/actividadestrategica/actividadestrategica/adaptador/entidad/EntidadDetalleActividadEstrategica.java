package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private Integer meta;

    @Column(name = "resultado_meta")
    private Integer resultadoMeta;

    @Column(name = "promedio_meta")
    private Integer promedioMeta;

    private String entregable;

    public EntidadDetalleActividadEstrategica(Integer meta, Integer resultadoMeta, Integer promedioMeta, String entregable) {
        this.meta = meta;
        this.resultadoMeta = resultadoMeta;
        this.promedioMeta = promedioMeta;
        this.entregable = entregable;
    }

    public EntidadDetalleActividadEstrategica(Long idDetalleActividadEstrategica, Integer meta, Integer resultadoMeta, Integer promedioMeta, String entregable) {
        this.idDetalleActividadEstrategica = idDetalleActividadEstrategica;
        this.meta = meta;
        this.resultadoMeta = resultadoMeta;
        this.promedioMeta = promedioMeta;
        this.entregable = entregable;
    }
}
