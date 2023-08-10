package com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_contrato")
public class EntidadTipoContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 50, name = "nombre")
    private String nombre;

    public EntidadTipoContrato() {
    }

    public EntidadTipoContrato(String nombre) {
        this.nombre = nombre;
    }
}
