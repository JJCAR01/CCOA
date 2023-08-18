package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "programa")
public class EntidadPrograma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 255, name = "nombre")
    private String nombre;

    @Column(unique = true, length = 255)
    private String codigo;

    @Column(unique = true, length = 255)
    private Integer version;

    @Column(unique = true, name = "fecha_inicio")
    private Date fechaInicio;

    @Column(unique = true, name = "fecha_final")
    private Date fechaFinal;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(unique = true, name = "presupuesto_ingreso")
    private Double presupuestoIngreso;

    @Column(unique = true, name = "presupuesto_gasto")
    private Double presupuestoGasto;

    @JoinColumn(name = "area_id")
    private Long idArea;

    @JoinColumn(name = "usuario_id")
    private Long idUsuario;

    @JoinColumn(name = "imperativo_estrategico_id")
    private Long idImperativoEstrategico;

    public EntidadPrograma() {
    }

    public EntidadPrograma(String nombre, String codigo, Integer version, Date fechaInicio, Date fechaFinal, Date fechaRegistro,
                           Double presupuestoIngreso, Double presupuestoGasto, Long idArea, Long idUsuario, Long idImperativoEstrategico) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.version = version;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.presupuestoIngreso = presupuestoIngreso;
        this.presupuestoGasto = presupuestoGasto;
        this.idArea = idArea;
        this.idUsuario = idUsuario;
        this.idImperativoEstrategico = idImperativoEstrategico;
    }
}


