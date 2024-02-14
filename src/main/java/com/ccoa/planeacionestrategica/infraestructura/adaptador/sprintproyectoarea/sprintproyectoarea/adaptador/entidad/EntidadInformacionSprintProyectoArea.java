package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "informacion_sprints_proyecto_area")
public class EntidadInformacionSprintProyectoArea {
    @Id
    @Column(name = "id_informacion_sprint_proyecto_area")
    private Long idInformacionSprintProyectoArea;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "porcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    public EntidadInformacionSprintProyectoArea(Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }

    public EntidadInformacionSprintProyectoArea(Long idInformacionSprintProyectoArea, Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.idInformacionSprintProyectoArea = idInformacionSprintProyectoArea;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
