package com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "direccion")
public class EntidadDireccion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long idDireccion;

    private String nombre;

    public EntidadDireccion(String nombre) {
        this.nombre = nombre;
    }
}
