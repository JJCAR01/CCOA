package com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@Table(name = "direcciones")
public class EntidadDireccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_direccion")
    private Long idDireccion;

    @Column(unique = true)
    private String nombre;

    public EntidadDireccion(String nombre) {
        this.nombre = nombre;
    }
}
