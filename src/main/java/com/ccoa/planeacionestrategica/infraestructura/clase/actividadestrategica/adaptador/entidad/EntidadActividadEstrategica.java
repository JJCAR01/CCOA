package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "actividad_estrategica")
public class EntidadActividadEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad_estrategica")
    private Long idActividadEstrategica;

    private String nombre;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;


    public EntidadActividadEstrategica(String nombre, LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
    }
}
