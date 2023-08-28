package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadRol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rol",nullable = false, length = 20)
    private String idRol;

    @Column(name = "nombre_rol",nullable = false, length = 20)
    private String nombreRol;

}
