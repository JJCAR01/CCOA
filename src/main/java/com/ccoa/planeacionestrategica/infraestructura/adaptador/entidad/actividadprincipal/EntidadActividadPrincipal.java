package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "actividad_principal")
public class EntidadActividadPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad_principal")
    private Long idActividadPrincipal;

    private String nombre;

    @Column(name = "tipo_actividad")
    private String tipoActividad;

    private String entregable;
    private Double presupuesto;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;


    public EntidadActividadPrincipal() {
    }

    public EntidadActividadPrincipal(String nombre, String tipoActividad,
                                     String entregable, Double presupuesto, LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.entregable = entregable;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
    }


}

