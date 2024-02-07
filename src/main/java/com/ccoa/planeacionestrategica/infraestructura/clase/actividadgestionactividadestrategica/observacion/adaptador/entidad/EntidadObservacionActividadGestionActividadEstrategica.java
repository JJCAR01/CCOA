package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "observacion_actividad_gestion_actividad_estrategica")
public class EntidadObservacionActividadGestionActividadEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_actividad_gestion_actividad_estrategica")
    private Long idObservacionActividadGestionActividadEstrategica;

    @Column(name = "id_actividad_gestion_actividad_estrategica")
    private Long idActividadGestionActividadEstrategica;

    private LocalDate fecha;
    private String nombre;

    public EntidadObservacionActividadGestionActividadEstrategica(Long idActividadGestionActividadEstrategica, LocalDate fecha, String nombre) {
        this.idActividadGestionActividadEstrategica = idActividadGestionActividadEstrategica;
        this.fecha = fecha;
        this.nombre = nombre;
    }

}
