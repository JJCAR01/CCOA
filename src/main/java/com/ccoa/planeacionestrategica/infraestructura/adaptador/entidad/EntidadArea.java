package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "area")
public class EntidadArea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_area")
    private Long idArea;

    @Column(unique = true, length = 50, name = "nombre")
    private String nombre;

    public EntidadArea() {
    }

    public EntidadArea(String nombre) {
        this.nombre = nombre;
    }
}
