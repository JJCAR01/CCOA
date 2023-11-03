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

    @JoinColumn(name = "id_actividad_estrategica")
    private Long idActividadEstrategica;

    @JoinColumn(name = "id_usuario")
    private Long idUsuario;

    public EntidadDetalleProyecto(Long idActividadEstrategica, Long idUsuario) {
        this.idActividadEstrategica = idActividadEstrategica;
        this.idUsuario = idUsuario;
    }
}
