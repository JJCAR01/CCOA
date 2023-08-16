package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cargo")
public class EntidadCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 50, name = "nombre")
    private String nombre;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "area_id")
    private EntidadArea area;

    @OneToMany(mappedBy = "cargo")
    private List<EntidadUsuario> usuarios;

    public EntidadCargo() {
    }

    public EntidadCargo(String nombre, EntidadArea area) {
        this.nombre = nombre;
        this.area = area;
    }
}
