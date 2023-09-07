package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.programa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "programa")
public class EntidadPrograma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_programa")
    private Long idPrograma;

    @Column(unique = true)
    private String nombre;

    private String codigo;

    private Integer version;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;


    public EntidadPrograma(String nombre, String codigo, Integer version, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.version = version;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
    }
}


