package com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rubro_gasto")
public class EntidadRubroGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 50, name = "nombre")
    private String nombre;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tipo_gi_id",unique = true)
    private EntidadTipoGI entidadTipoGI;

    public EntidadRubroGasto() {
    }

    public EntidadRubroGasto(String nombre) {
        this.nombre = nombre;
    }
}
