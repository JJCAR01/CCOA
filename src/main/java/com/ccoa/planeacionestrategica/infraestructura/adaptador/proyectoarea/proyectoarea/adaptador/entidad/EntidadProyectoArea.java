package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EModalidad;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "proyectos_area")
public class EntidadProyectoArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_proyecto_area")
    private Long idProyectoArea;

    private String nombre;
    private Double presupuesto;

    @Enumerated(EnumType.STRING)
    private EModalidad modalidad;

    @Column(name = "valor_ejecutado")
    private Double valorEjecutado;

    @JoinColumn(name = "id_pat")
    private Long idPat;

    @JoinColumn(name = "id_usuario")
    private Long idUsuario;

    public EntidadProyectoArea(String nombre, Double presupuesto, EModalidad modalidad, Double valorEjecutado, Long idPat, Long idUsuario) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.modalidad = modalidad;
        this.valorEjecutado = valorEjecutado;
        this.idPat = idPat;
        this.idUsuario = idUsuario;
    }
}
