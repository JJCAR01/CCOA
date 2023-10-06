package com.ccoa.planeacionestrategica.infraestructura.clase.cargo.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cargo")
public class EntidadCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cargo")
    private Long idCargo;

    @Column(unique = true, length = 50)
    private String nombre;

    @Column(name="id_area")
    private Long idArea;

    public EntidadCargo(String nombre, Long idArea) {
        this.nombre = nombre;
        this.idArea = idArea;
    }

}
