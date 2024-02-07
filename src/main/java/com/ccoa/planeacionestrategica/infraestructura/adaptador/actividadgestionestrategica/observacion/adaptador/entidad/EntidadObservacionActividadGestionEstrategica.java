package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "observaciones_actividad_gestion_estrategica")
public class EntidadObservacionActividadGestionEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_actividad_gestion_estrategica")
    private Long idObservacionActividadGestionEstrategica;

    @Column(name = "id_actividad_gestion_estrategica")
    private Long idActividadGestionEstrategica;

    private LocalDate fecha;
    private String nombre;

    public EntidadObservacionActividadGestionEstrategica(Long idActividadGestionEstrategica, LocalDate fecha, String nombre) {
        this.idActividadGestionEstrategica = idActividadGestionEstrategica;
        this.fecha = fecha;
        this.nombre = nombre;
    }

}
