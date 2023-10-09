package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "epica")
public class EntidadEpica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_epica")
    private Long idEpica;

    private String nombre;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @JoinColumn(name = "id_informacion_epica")
    private Long idInformacionEpica;

    public EntidadEpica(String nombre, LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaRegistro, Long idInformacionEpica) {
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idInformacionEpica = idInformacionEpica;
    }
}
