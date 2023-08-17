package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol_usuario")
public class EntidadRol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rol;
    private String descripcion;

    public EntidadRol() {
    }

    public EntidadRol(String rol, String descripcion) {
        this.rol = rol;
        this.descripcion = descripcion;
    }
}
