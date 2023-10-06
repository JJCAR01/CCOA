package com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "informacion_actividad")
public class EntidadInformacionActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_informacion_actividad")
    private Long idInformacionActividad;

    private Integer duracion;
    @Column(name = "dias_restantes")
    private Integer diasRestantes;
    private Double avance;
    private Long idEpica;
    private Long idGestion;

    public EntidadInformacionActividad(Integer duracion, Integer diasRestantes, Double avance, Long idEpica, Long idGestion) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.avance = avance;
        this.idEpica = idEpica;
        this.idGestion = idGestion;
    }
}
