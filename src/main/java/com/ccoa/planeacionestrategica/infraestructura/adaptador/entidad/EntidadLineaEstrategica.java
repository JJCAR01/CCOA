package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "linea_estrategica")
public class EntidadLineaEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private String entregable;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_final")
    private Date fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "indicador_resultado")
    private String indicadorResultado;

    @JoinColumn(name = "usuario_id")
    private Long idUsuario;

    @JoinColumn(name = "programa_id")
    private Long idPrograma;

    public EntidadLineaEstrategica() {
    }

    public EntidadLineaEstrategica(String nombre, String entregable, Date fechaInicio, Date fechaFinal,
                                   LocalDateTime fechaRegistro, String indicadorResultado, Long idUsuario, Long idPrograma) {
        this.nombre = nombre;
        this.entregable = entregable;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.indicadorResultado = indicadorResultado;
        this.idUsuario = idUsuario;
        this.idPrograma = idPrograma;
    }
}


