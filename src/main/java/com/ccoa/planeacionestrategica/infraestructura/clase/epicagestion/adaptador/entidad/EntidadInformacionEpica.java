package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "informacion_epica")
public class EntidadInformacionEpica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_informacion_epica")
    private Long idInformacionEpica;

    private Integer duracion;

    @Column(name = "dias_restantes")
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
