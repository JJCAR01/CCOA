package com.ccoa.planeacionestrategica.infraestructura.adaptador.proceso.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "procesos")
public class EntidadProceso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_proceso")
    private Long idProceso;

    @Column(unique = true)
    private String nombre;

    public EntidadProceso(String nombre) {
        this.nombre = nombre;
    }
}
