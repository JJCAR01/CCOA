package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sprints")
public class EntidadSprint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sprint")
    private Long idSprint;

    private String descripcion;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @JoinColumn(name = "id_proyecto")
    private Long idProyecto;

    public  EntidadSprint(String descripcion, LocalDate fechaInicial, LocalDate fechaFinal, Long idProyecto) {
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idProyecto = idProyecto;
    }
}
