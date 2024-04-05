package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "detalle_proyectos_area")
public class EntidadDetalleProyectoArea {

    @Id
    @Column(name = "id_detalle_proyecto_area")
    private Long idDetalleProyectoArea;

    private Integer duracion;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "porcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    public EntidadDetalleProyectoArea(Integer duracion, Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.duracion = duracion;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }

    public EntidadDetalleProyectoArea(Long idDetalleProyectoArea, Integer duracion, Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.idDetalleProyectoArea = idDetalleProyectoArea;
        this.duracion = duracion;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
