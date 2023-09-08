package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.gastoingreso;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.gastoingreso.enums.ETipoGI;
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
    @Column(name = "id_tipo_gi")
    private Long idTipoGI;

    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETipoGI clasificacion;

    @Column(name = "valor_unitario")
    private Double valorUnitario;

    @Column(name = "valor_total")
    private Double valorTotal;

    private String observacion;


    public EntidadTipoGI() {
    }

    public EntidadTipoGI(Integer cantidad, String clasificacion, Double valorUnitario, Double valorTotal, String observacion) {
        this.cantidad = cantidad;
        this.clasificacion = ETipoGI.valueOf(clasificacion);
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.observacion = observacion;
    }

}
