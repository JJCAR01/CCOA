package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sprints_proyecto_area")
public class EntidadSprintProyectoArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sprint_proyecto_area")
    private Long idSprintProyectoArea;

    private String descripcion;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @JoinColumn(name = "id_proyecto_area")
    private Long idProyectoArea;

    public EntidadSprintProyectoArea(String descripcion, LocalDate fechaInicial, LocalDate fechaFinal, Long idProyectoArea) {
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idProyectoArea = idProyectoArea;
    }
}
