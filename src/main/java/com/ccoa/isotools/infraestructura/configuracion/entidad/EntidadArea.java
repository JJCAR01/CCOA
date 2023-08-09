package com.ccoa.isotools.infraestructura.configuracion.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "area")
public class EntidadArea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 50, name = "nombre")
    private String nombre;

    public EntidadArea() {
    }

    public EntidadArea(String nombre) {
        this.nombre = nombre;
    }
}
