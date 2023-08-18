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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo_actividad")
    private String tipoActividad;
    @Column(name = "entregable")
    private String entregable;
    @Column(name = "presupuesto")
    private Double presupuesto;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_final")
    private Date fechaFinal;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    @Column(name = "usuario_id")
    private Long idUsuario;
    @Column(name = "tipo_gi_id")
    private Long idTipoGI;
    @Column(name = "linea_estrategica_id")
    private Long idLineaEstrategica;

    public EntidadActividadPrincipal() {
    }

    public EntidadActividadPrincipal(String nombre, String tipoActividad,
                                     String entregable, Double presupuesto, Date fechaInicio, Date fechaFinal, Date fechaRegistro,
                                     Long idUsuario, Long idTipoGI, Long idLineaEstrategica) {
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.entregable = entregable;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
        this.idTipoGI = idTipoGI;
        this.idLineaEstrategica = idLineaEstrategica;
    }


}

