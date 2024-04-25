package com.ccoa.planeacionestrategica.infraestructura.adaptador.clasificacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "clasificaciones")
public class EntidadClasificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_clasificacion")
    private Long idClasificacion;

    @Column(unique = true)
    private String nombre;

    private boolean estado;

    public EntidadClasificacion(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
}
