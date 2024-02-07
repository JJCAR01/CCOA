package com.ccoa.planeacionestrategica.infraestructura.clase.tarea.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "observacion_tarea")
public class EntidadObservacionTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_tarea")
    private Long idObservacionTarea;

    @Column(name = "id_tarea")
    private Long idTarea;

    private LocalDate fecha;
    private String nombre;

    public EntidadObservacionTarea(Long idTarea, LocalDate fecha, String nombre) {
        this.idTarea = idTarea;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
