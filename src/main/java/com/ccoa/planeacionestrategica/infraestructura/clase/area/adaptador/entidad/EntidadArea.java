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

    private String nombre;

    @JoinColumn(name = "id_direccion")
    private Long idDireccion;

    public EntidadArea(String nombre, Long idDireccion) {
        this.nombre = nombre;
        this.idDireccion = idDireccion;
    }
}
