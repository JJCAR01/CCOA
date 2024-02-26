package com.ccoa.planeacionestrategica.infraestructura.adaptador.cargo.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table(name = "cargos")
public class EntidadCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cargo")
    private Long idCargo;

    private String nombre;

    @Column(name="id_area")
    private Long idArea;

    public EntidadCargo(String nombre, Long idArea) {
        this.nombre = nombre;
        this.idArea = idArea;
    }

}
