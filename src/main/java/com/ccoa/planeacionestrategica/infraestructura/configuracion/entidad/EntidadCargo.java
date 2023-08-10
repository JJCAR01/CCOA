package com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cargo")
public class EntidadCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 50, name = "nombre")
    private String nombre;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "area_id",unique = true)
    private EntidadArea area;

    public EntidadCargo() {
    }

    public EntidadCargo(String nombre, EntidadArea area) {
        this.nombre = nombre;
        this.area = area;
    }
}
