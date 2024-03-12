package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "observaciones_sprint_proyecto_area")
public class EntidadObservacionSprintProyectoArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_sprint_proyecto_area")
    private Long idObservacionSprintProyectoArea;

    @Column(name = "id_sprint")
    private Long idSprintProyectoArea;

    private LocalDate fecha;
    private String descripcion;

    public EntidadObservacionSprintProyectoArea(Long idSprintProyectoArea, LocalDate fecha, String descripcion) {
        this.idSprintProyectoArea = idSprintProyectoArea;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
