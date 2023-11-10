package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "datelle_proyecto")
public class EntidadDetalleProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_detalle_proyecto")
    private Long idDetalleProyecto;

    private Double avance;

    @JoinColumn(name = "id_actividad_estrategica")
    private Long idActividadEstrategica;

    @JoinColumn(name = "id_usuario")
    private Long idUsuario;

    public EntidadDetalleProyecto(Double avance, Long idActividadEstrategica, Long idUsuario) {
        this.avance = avance;
        this.idActividadEstrategica = idActividadEstrategica;
        this.idUsuario = idUsuario;
    }
}
