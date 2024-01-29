package com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EPeriodicidad;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
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

    private String observacion;

    @Enumerated(EnumType.STRING)
    private EPeriodicidad periodicidad;

    private Double porcentaje;

    public EntidadInformacionTarea(String observacion, EPeriodicidad periodicidad, Double porcentaje) {
        this.observacion = observacion;
        this.periodicidad = periodicidad;
        this.porcentaje = porcentaje;
    }
}
