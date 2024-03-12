package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "observaciones_sprint")
public class EntidadObservacionSprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_sprint")
    private Long idObservacionSprint;

    @Column(name = "id_sprint")
    private Long idSprint;

    private LocalDate fecha;
    private String descripcion;

    public EntidadObservacionSprint(Long idSprint, LocalDate fecha, String descripcion) {
        this.idSprint = idSprint;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
