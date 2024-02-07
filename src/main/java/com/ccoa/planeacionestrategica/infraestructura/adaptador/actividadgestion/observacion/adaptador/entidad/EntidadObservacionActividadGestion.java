package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "observaciones_actividad_gestion")
public class EntidadObservacionActividadGestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_actividad_gestion")
    private Long idObservacionActividadGestion;

    @Column(name = "id_actividad_gestion")
    private Long idActividadGestion;

    private LocalDate fecha;
    private String nombre;

    public EntidadObservacionActividadGestion(Long idActividadGestion, LocalDate fecha, String nombre) {
        this.idActividadGestion = idActividadGestion;
        this.fecha = fecha;
        this.nombre = nombre;
    }

}
