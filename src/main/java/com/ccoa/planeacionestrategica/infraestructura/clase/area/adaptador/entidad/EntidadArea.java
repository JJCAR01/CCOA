package com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
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

    @Enumerated(EnumType.STRING)
    private EDireccion direccion;

    public EntidadArea(String nombre, EDireccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
