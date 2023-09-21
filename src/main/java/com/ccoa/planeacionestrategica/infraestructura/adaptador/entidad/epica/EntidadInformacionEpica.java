package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.epica;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "informacion_epica")
public class EntidadInformacionEpica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_informacion_epica")
    private Long idInformacionEpica;

    private Integer duracion;

    @Column(unique = true, name = "dias_restantes")
    private Integer diasRestantes;

    private Boolean estado;
    private Double avance;

    public EntidadInformacionEpica(Integer duracion, Integer diasRestantes, Boolean estado, Double avance) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.estado = estado;
        this.avance = avance;
    }
}
