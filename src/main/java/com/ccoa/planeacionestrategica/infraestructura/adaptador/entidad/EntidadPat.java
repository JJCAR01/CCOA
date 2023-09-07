package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pat")
public class EntidadPat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pat")
    private Long idPat;

    @Column(unique = true,   name = "nombre")
    private String nombre;

    @Column( name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column( name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "porcentaje_esperado")
    private Double porcentajeEsperado;

    private Double cumplimiento;

    @JoinColumn(name = "usuario_id")
    private Long idUsuario;

    public EntidadPat() {
    }

    public EntidadPat(String nombre, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro, Double porcentajeReal, Double porcentajeEsperado,
                      Double cumplimiento, Long idUsuario) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.cumplimiento = cumplimiento;
        this.idUsuario = idUsuario;
    }

}
