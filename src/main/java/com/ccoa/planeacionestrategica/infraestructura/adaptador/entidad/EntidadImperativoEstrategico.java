package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "imperativo_estrategico")
public class EntidadImperativoEstrategico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_imperativo_estrategico")
    private Long idImperativoEstrategico;

    @Column(unique = true)
    private String nombre;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_final")
    private Date fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "porcentaje_esperado")
    private Double porcentajeEsperado;

    private Double cumplimiento;

    @JoinColumn(name = "pat_id",unique = true)
    private Long idPat;

    @JoinColumn(name = "usuario_id",unique = true)
    private Long idUsuario;

    public EntidadImperativoEstrategico() {
    }

    public EntidadImperativoEstrategico(String nombre, Date fechaInicio,
                                        Date fechaFinal, LocalDateTime fechaRegistro, Double porcentajeReal, Double porcentajeEsperado,
                                        Double cumplimiento, Long idPat, Long idUsuario) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.cumplimiento = cumplimiento;
        this.idPat = idPat;
        this.idUsuario = idUsuario;
    }
}
