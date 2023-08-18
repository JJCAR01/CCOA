package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tipo_gi")
public class EntidadTipoGI {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer cantidad;

    @Column(name = "valor_unitario")
    private Double valorUnitario;

    @Column(name = "valor_total")
    private Double valorTotal;

    private String observacion;

    private String clasificacion;

    public EntidadTipoGI() {
    }

    public EntidadTipoGI(Integer cantidad, Double valorUnitario, Double valorTotal, String observacion, String clasificacion) {
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.observacion = observacion;
        this.clasificacion = clasificacion;
    }
}
