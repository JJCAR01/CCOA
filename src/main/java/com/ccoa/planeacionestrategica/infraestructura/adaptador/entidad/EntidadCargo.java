package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
@Table(name = "cargo")
public class EntidadCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_cargo;

    @Column(unique = true, length = 50)
    private String nombre;

    @Column(name="area_id")
    private Long idArea;

    public EntidadCargo() {
    }

    public EntidadCargo(String nombre, Long idArea) {
        this.nombre = nombre;
        this.idArea = idArea;
    }

}