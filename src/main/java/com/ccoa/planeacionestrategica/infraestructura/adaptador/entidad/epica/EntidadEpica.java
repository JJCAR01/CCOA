package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.epica;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "epica")
public class EntidadEpica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_epica")
    private Long idEpica;

    @Column(unique = true)
    private String nombre;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "usuario_id")
    private Long idUsuario;


    public EntidadEpica(String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Long idUsuario) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
    }
}


