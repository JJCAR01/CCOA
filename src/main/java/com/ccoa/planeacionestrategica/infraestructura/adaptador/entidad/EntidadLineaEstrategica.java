package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "linea_estrategica")
public class EntidadLineaEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_linea_estrategica")
    private Long idLineaEstrategica;

    @Column(unique = true)
    private String nombre;

    private String entregable;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "indicador_resultado")
    private String indicadorResultado;

    @JoinColumn(name = "usuario_id")
    private Long idUsuario;

    @JoinColumn(name = "programa_id")
    private Long idPrograma;

    public EntidadLineaEstrategica() {
    }

    public EntidadLineaEstrategica(String nombre, String entregable, LocalDate fechaInicio, LocalDate fechaFinal,
                                   LocalDate fechaRegistro, String indicadorResultado, Long idUsuario, Long idPrograma) {
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


