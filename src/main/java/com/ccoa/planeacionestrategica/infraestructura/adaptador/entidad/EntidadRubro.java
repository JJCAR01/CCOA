package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rubro")
public class EntidadRubro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 50, name = "nombre")
    private String nombre;

    @JoinColumn(name = "tipo_gi_id",unique = true)
    private Long idTipoGI;

    public EntidadRubro() {
    }

    public EntidadRubro(String nombre, Long idTipoGI) {
        this.nombre = nombre;
        this.idTipoGI = idTipoGI;
    }
}
