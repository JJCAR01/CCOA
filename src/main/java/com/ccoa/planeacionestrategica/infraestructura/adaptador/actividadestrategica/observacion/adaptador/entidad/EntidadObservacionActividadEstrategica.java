package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "observaciones_actividad_estrategica")
public class EntidadObservacionActividadEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_actividad_estrategica")
    private Long idObservacionActividadEstrategica;

    @Column(name = "id_actividad_estrategica")
    private Long idActividadEstrategica;

    private LocalDate fecha;
    private String descripcion;

    public EntidadObservacionActividadEstrategica(Long idActividadEstrategica, LocalDate fecha, String descripcion) {
        this.idActividadEstrategica = idActividadEstrategica;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

}
