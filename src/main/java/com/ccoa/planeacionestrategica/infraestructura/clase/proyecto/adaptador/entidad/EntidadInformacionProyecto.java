package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.enums.EPlaneacionSprint;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "informacion_proyecto")
public class EntidadInformacionProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_informacion_proyecto")
    private Long id;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    private Integer duracion;

    @Column(name = "planeacion_sprint")
    private EPlaneacionSprint planeacionSprint;

    @Column(name = "total_sprint")
    private Integer totalSprint;

    public EntidadInformacionProyecto(LocalDate fechaInicial, LocalDate fechaFinal, Integer duracion, EPlaneacionSprint planeacionSprint, Integer totalSprint) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.duracion = duracion;
        this.planeacionSprint = planeacionSprint;
        this.totalSprint = totalSprint;
    }

}
