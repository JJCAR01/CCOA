package com.ccoa.planeacionestrategica.infraestructura.adaptador.area.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "areas")
public class EntidadArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_area")
    private Long idArea;

    private String nombre;

    @JoinColumn(name = "id_direccion")
    private Long idDireccion;

    public EntidadArea(String nombre, Long idDireccion) {
        this.nombre = nombre;
        this.idDireccion = idDireccion;
    }
}
