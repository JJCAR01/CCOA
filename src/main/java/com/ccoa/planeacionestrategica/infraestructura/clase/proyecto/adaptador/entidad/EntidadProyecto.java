package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.enums.EModalidad;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "proyecto")
public class EntidadProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_proyecto")
    private Long idProyecto;

    private String nombre;
    private Double presupuesto;

    @Enumerated(EnumType.STRING)
    private EModalidad modalidad;

    @Column(name = "valor_ejecutado")
    private Double valorEjecutado;

    private Boolean estado;

    public EntidadProyecto(String nombre, Double presupuesto, EModalidad modalidad, Double valorEjecutado, Boolean estado) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.modalidad = modalidad;
        this.valorEjecutado = valorEjecutado;
        this.estado = estado;
    }
}
