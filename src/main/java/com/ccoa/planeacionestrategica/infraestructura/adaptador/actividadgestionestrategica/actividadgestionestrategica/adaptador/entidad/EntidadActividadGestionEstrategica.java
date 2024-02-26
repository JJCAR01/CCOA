package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "actividades_gestion_estrategicas")
public class EntidadActividadGestionEstrategica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad_gestion_actividad_estrategica")
    private Long idActividadGestionEstrategica;

    private String nombre;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @JoinColumn(name = "id_usuario")
    private Long idUsuario;

    @JoinColumn(name = "id_actividad_estrategica")
    private Long idActividadEstrategica;

    public EntidadActividadGestionEstrategica(String nombre, LocalDate fechaInicial,
                                              LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario, Long idActividadEstrategica) {
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
        this.idActividadEstrategica = idActividadEstrategica;
    }
}
