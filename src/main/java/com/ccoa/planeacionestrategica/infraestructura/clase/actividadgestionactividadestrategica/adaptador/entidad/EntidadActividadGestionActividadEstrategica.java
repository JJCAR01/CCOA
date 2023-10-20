package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "actividad_gestion_actividad_estrategica")
public class EntidadActividadGestionActividadEstrategica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad_gestion_actividad_estrategica")
    private Long idActividadGestionActividadEstrategica;
    private String nombre;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @JoinColumn(name = "id_usuario")
    private Long idUsuario;
    @JoinColumn(name = "id_actividad_estrategica")
    private Long idActividadEstrategica;

    public EntidadActividadGestionActividadEstrategica(String nombre, LocalDate fechaInicial, LocalDate fechaFinal, Long idUsuario, Long idActividadEstrategica) {
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idUsuario = idUsuario;
        this.idActividadEstrategica = idActividadEstrategica;
    }
}
