package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.programa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "informacion_programa")
public class EntidadInformacionPrograma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_informacion_programa")
    private Long idInformacionPrograma;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "porcentaje_esperado")
    private Double porcentajeEsperado;

    private Double cumplimiento;

    @Column(unique = true, name = "presupuesto_ingreso")
    private Double presupuestoIngreso;

    @Column(unique = true, name = "presupuesto_gasto")
    private Double presupuestoGasto;


    public EntidadInformacionPrograma(Double porcentajeReal, Double porcentajeEsperado, Double cumplimiento, Double presupuestoIngreso, Double presupuestoGasto) {
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.cumplimiento = cumplimiento;
        this.presupuestoIngreso = presupuestoIngreso;
        this.presupuestoGasto = presupuestoGasto;
    }
}
