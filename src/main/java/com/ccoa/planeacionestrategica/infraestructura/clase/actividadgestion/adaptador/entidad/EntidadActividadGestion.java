package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "actividad")
public class EntidadActividadGestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad_gestion")
    private Long idActividadGestion;
    private String nombre;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @JoinColumn(name = "id_usuario")
    private Long idUsuario;
    @JoinColumn(name = "id_pat")
    private Long idPat;

    public EntidadActividadGestion(String nombre, LocalDate fechaInicial, LocalDate fechaFinal, Long idUsuario, Long idPat) {
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idUsuario = idUsuario;
        this.idPat = idPat;
    }
}
