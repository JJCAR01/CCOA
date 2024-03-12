package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "observaciones_tarea")
public class EntidadObservacionTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_tarea")
    private Long idObservacionTarea;

    @Column(name = "id_tarea")
    private Long idTarea;

    private LocalDate fecha;
    private String descripcion;

    public EntidadObservacionTarea(Long idTarea, LocalDate fecha, String descripcion) {
        this.idTarea = idTarea;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
