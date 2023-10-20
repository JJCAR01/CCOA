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
@Table(name = "informacion_actividad_gestion_actividad_estrategica")
public class EntidadInformacionActividadGestionActividadEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_informacion_actividad_gestion_actividad_estrategica")
    private Long idInformacionActividadActividadEstrategica;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    private Integer duracion;
    @Column(name = "dias_restantes")
    private Integer diasRestantes;
    private Double avance;

    public EntidadInformacionActividadGestionActividadEstrategica(LocalDate fechaRegistro, Integer duracion, Integer diasRestantes, Double avance) {
        this.fechaRegistro = fechaRegistro;
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.avance = avance;
    }
}
