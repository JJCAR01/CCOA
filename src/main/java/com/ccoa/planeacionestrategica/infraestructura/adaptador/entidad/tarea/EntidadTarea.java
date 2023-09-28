package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.tarea;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tarea")
public class EntidadTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_tarea")
    private Long idTarea;

    @Column(unique = true)
    private String nombre;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @JoinColumn(name = "usuario_id")
    private Long idUsuario;

    @JoinColumn(name = "pat_id")
    private Long idPat;


    public EntidadTarea(String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario, Long idPat) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
        this.idPat = idPat;
    }
}


