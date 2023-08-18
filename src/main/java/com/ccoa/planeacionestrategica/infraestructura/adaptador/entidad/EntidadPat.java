package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pat")
public class EntidadPat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 255, name = "nombre")
    private String nombre;

    @Column(unique = true, name = "fecha_inicio")
    private Date fechaInicio;

    @Column(unique = true, name = "fecha_final")
    private Date fechaFinal;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @JoinColumn(name = "usuario_id")
    private Long idUsuario;

    public EntidadPat() {
    }

    public EntidadPat(String nombre, Date fechaInicio, Date fechaFinal, Date fechaRegistro, Long idUsuario) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
    }
}
