package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPlaneacionSprint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "informacion_proyectos_area")
public class EntidadInformacionProyectoArea {
    @Id
    @Column(name = "id_informacion_proyecto_area")
    private Long idInformacionProyectoArea;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "planeacion_sprint")
    private EPlaneacionSprint planeacionSprint;

    @Column(name = "total_sprint")
    private Integer totalSprint;

    public EntidadInformacionProyectoArea(LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaRegistro, EPlaneacionSprint planeacionSprint, Integer totalSprint) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.planeacionSprint = planeacionSprint;
        this.totalSprint = totalSprint;
    }
}
