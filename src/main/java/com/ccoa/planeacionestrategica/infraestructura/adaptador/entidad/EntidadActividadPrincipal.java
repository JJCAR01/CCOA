package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "actividad_principal")
public class EntidadActividadPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 255, name = "nombre")
    private String nombre;

    @Column(unique = true, length = 255, name = "tipo_actividad")
    private String tipoActividad;

    @Column(unique = true, length = 255)
    private String entregable;

    @Column(unique = true, length = 255)
    private Double presupuesto;

    @Column(unique = true, name = "fecha_inicio")
    private Date fechaInicio;

    @Column(unique = true, name = "fecha_final")
    private Date fechaFinal;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "usuario_id")
    private EntidadUsuario usuario;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tipo_gi_id")
    private EntidadTipoGI tipoGI;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "linea_estrategica_id")
    private EntidadLineaEstrategica lineaEstrategica;

    @OneToMany(mappedBy = "actividadPrincipal")
    private List<EntidadRegistroActividad> registroActividades;

    @OneToMany(mappedBy = "actividadPrincipal")
    private List<EntidadEjecutado> ejecutados;

    public EntidadActividadPrincipal() {
    }

    public EntidadActividadPrincipal(String nombre, String tipoActividad, String entregable, Double presupuesto,
                                     Date fechaInicio, Date fechaFinal, Date fechaRegistro, EntidadUsuario usuario, EntidadTipoGI tipoGI, EntidadLineaEstrategica lineaEstrategica) {
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.entregable = entregable;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.usuario = usuario;
        this.tipoGI = tipoGI;
        this.lineaEstrategica = lineaEstrategica;
    }
}

