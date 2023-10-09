package com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "area")
public class EntidadArea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_area")
    private Long idArea;

    @Column(unique = true, length = 50, name = "nombre")
    private String nombre;

    public EntidadArea(String nombre) {
        this.nombre = nombre;
    }
}