package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_gestion")
    private Long idGestion;

    private String nombre;

    @Column(name = "id_pat")
    private Long idPat;

    public EntidadGestion(String nombre, Long idPat) {
        this.nombre = nombre;
        this.idPat = idPat;
    }
}
