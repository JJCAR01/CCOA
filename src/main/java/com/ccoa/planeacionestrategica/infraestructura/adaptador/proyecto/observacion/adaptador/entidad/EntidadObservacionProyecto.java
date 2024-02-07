package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "observaciones_proyecto")
public class EntidadObservacionProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_proyecto")
    private Long idObservacionProyecto;

    @Column(name = "id_proyecto")
    private Long idProyecto;

    private LocalDate fecha;
    private String nombre;

    public EntidadObservacionProyecto(Long idProyecto, LocalDate fecha, String nombre) {
        this.idProyecto = idProyecto;
        this.fecha = fecha;
        this.nombre = nombre;
    }

}
