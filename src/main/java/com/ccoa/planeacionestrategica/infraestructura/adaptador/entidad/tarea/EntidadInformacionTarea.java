package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.tarea;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "informacion_tarea")
public class EntidadInformacionTarea{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_informacion_tarea")
    private Long idInformacionTarea;

    private Integer duracion;

    @Column(unique = true, name = "dias_restantes")
    private Integer diasRestantes;

    private Boolean estado;
    private Double avance;

    public EntidadInformacionTarea(Integer duracion, Integer diasRestantes, Boolean estado, Double avance) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.estado = estado;
        this.avance = avance;
    }

}
