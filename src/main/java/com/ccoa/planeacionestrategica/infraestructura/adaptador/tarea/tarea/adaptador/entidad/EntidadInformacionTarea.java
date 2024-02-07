package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidad;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "informacion_tareas")
public class EntidadInformacionTarea {

    @Id
    @Column(name = "id_informacion_tarea")
    private Long idInformacionTarea;

    @Enumerated(EnumType.STRING)
    private EPeriodicidad periodicidad;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "iporcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    public EntidadInformacionTarea(EPeriodicidad periodicidad, Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.periodicidad = periodicidad;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
