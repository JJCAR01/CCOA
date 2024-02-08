package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "informacion_sprints")
public class EntidadInformacionSprint {
    @Id
    @Column(name = "id_informacion_sprint")
    private Long idInformacionSprint;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "porcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    public EntidadInformacionSprint(Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
