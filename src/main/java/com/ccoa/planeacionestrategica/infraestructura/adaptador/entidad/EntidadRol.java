package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol")
public class EntidadRol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rol;

    public EntidadRol() {
    }

    public EntidadRol(String rol) {
        this.rol = rol;
    }
}