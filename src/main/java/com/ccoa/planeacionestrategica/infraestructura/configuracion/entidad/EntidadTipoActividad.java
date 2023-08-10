package com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_actividad")
public class EntidadTipoActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 50, name = "nombre")
    private String nombre;

    public EntidadTipoActividad() {
    }

    public EntidadTipoActividad(String nombre) {
        this.nombre = nombre;
    }
}
