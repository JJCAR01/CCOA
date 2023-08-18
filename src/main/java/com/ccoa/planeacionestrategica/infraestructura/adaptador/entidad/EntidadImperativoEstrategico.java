package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "imperativo_estrategico")
public class EntidadImperativoEstrategico {

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

    @JoinColumn(name = "pat_id",unique = true)
    private Long idPat;

    @JoinColumn(name = "usuario_id",unique = true)
    private Long idUsuario;

    public EntidadImperativoEstrategico() {
    }

    public EntidadImperativoEstrategico(String nombre, Date fechaInicio, Date fechaFinal, Date fechaRegistro, Long idPat, Long idUsuario) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idPat = idPat;
        this.idUsuario = idUsuario;
    }
}
