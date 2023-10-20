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
    @Column(name = "id_informacion_actividad_estrategica")
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

    @JoinColumn(name = "id_usuario")
    private Long idUsuario;

    public EntidadInformacionProyecto(LocalDate fechaInicial, LocalDate fechaFinal, Integer duracion, EPlaneacionSprint planeacionSprint, Integer totalSprint, Long idUsuario) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.duracion = duracion;
        this.planeacionSprint = planeacionSprint;
        this.totalSprint = totalSprint;
        this.idUsuario = idUsuario;
    }
}
