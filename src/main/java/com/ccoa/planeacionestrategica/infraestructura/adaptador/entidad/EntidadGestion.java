package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gestion")
public class EntidadGestion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_gestion")
    private Long idGestion;

    private String nombre;

    @JoinColumn(name = "pat_id")
    private Long idPat;

    public EntidadGestion() {
    }

    public EntidadGestion(String nombre, Long idPat) {
        this.nombre = nombre;
        this.idPat = idPat;
    }

}
