package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "gestion")
public class EntidadGestion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_gestion")
    private Long idGestion;

    private String nombre;

    @JoinColumn(name = "pat_id")
    private Long idPat;


    public EntidadGestion(Long idGestion, String nombre, Long idPat) {
        this.idGestion = idGestion;
        this.nombre = nombre;
        this.idPat = idPat;
    }

}
