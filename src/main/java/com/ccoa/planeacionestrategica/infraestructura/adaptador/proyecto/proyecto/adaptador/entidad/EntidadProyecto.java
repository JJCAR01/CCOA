package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EModalidad;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "proyectos")
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

    @JoinColumn(name = "id_actividad_estrategica")
    private Long idActividadEstrategica;

    @JoinColumn(name = "id_usuario")
    private Long idUsuario;

    public EntidadProyecto(String nombre, Double presupuesto, EModalidad modalidad, Double valorEjecutado, Long idActividadEstrategica, Long idUsuario) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.modalidad = modalidad;
        this.valorEjecutado = valorEjecutado;
        this.idActividadEstrategica = idActividadEstrategica;
        this.idUsuario = idUsuario;
    }
}
