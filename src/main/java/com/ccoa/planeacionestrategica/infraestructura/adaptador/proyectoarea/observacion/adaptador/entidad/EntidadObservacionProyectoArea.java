package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "observaciones_proyecto")
public class EntidadObservacionProyectoArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_proyecto_area")
    private Long idObservacionProyectoArea;

    @Column(name = "id_proyecto_area")
    private Long idProyectoArea;

    private LocalDate fecha;
    private String nombre;

    public EntidadObservacionProyectoArea(Long idProyectoArea, LocalDate fecha, String nombre) {
        this.idProyectoArea = idProyectoArea;
        this.fecha = fecha;
        this.nombre = nombre;
    }

}
