package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@Table(name = "datalle_proyectos")
public class EntidadDetalleProyecto {

    @Id
    @Column(name = "id_detalle_proyecto")
    private Long idDetalleProyecto;

    private Integer duracion;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "iporcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    public EntidadDetalleProyecto(Integer duracion, Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.duracion = duracion;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
