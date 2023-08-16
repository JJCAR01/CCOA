package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "linea_estrategica")
public class EntidadLineaEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 255, name = "nombre")
    private String nombre;

    @Column(unique = true, length = 255)
    private String entregable;

    @Column(unique = true, name = "fecha_inicio")
    private Date fechaInicio;

    @Column(unique = true, name = "fecha_final")
    private Date fechaFinal;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "indicador_resultado")
    private String indicadorResultado;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "usuario_id")
    private EntidadUsuario usuario;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "programa_id")
    private EntidadPrograma programa;

    public EntidadLineaEstrategica() {
    }

    public EntidadLineaEstrategica(String nombre, String entregable, Date fechaInicio, Date fechaFinal,
                                   Date fechaRegistro, String indicadorResultado, EntidadUsuario usuario, EntidadPrograma programa) {
        this.nombre = nombre;
        this.entregable = entregable;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.indicadorResultado = indicadorResultado;
        this.usuario = usuario;
        this.programa = programa;
    }
}


