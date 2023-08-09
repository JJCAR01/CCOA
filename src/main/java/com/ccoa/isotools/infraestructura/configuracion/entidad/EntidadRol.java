package com.ccoa.isotools.infraestructura.configuracion.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol")
public class EntidadRol {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 10, name = "nombre")
    private String nombre;

    public EntidadRol() {
    }

    public EntidadRol(String nombre) {
        this.nombre = nombre;
    }
}
