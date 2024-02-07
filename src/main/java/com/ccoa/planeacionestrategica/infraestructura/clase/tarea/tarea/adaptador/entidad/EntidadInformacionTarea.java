package com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EPeriodicidad;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "informacion_tarea")
public class EntidadInformacionTarea {

    @Id
    @Column(name = "id_informacion_tarea")
    private Long idInformacionTarea;

    @Enumerated(EnumType.STRING)
    private EPeriodicidad periodicidad;

    private Double porcentaje;

    public EntidadInformacionTarea(EPeriodicidad periodicidad, Double porcentaje) {
        this.periodicidad = periodicidad;
        this.porcentaje = porcentaje;
    }
}
