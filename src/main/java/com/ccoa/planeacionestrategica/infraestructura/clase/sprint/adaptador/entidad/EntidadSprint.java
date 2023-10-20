package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "sprint")
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

    private Double avance;

    private Boolean estado;

    @JoinColumn(name = "id_proyecto")
    private Long idProyecto;

    public  EntidadSprint(String descripcion, LocalDate fechaInicial, LocalDate fechaFinal, Double avance, Boolean estado, Long idProyecto) {
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.avance = avance;
        this.estado = estado;
        this.idProyecto = idProyecto;
    }
}
