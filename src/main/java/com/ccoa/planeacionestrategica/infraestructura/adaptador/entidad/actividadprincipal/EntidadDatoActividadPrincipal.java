package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "dato_actividad_principal")
public class EntidadDatoActividadPrincipal {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_daro_actividad_principal")
    private Long idDatoAtividadPrincipal;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    public EntidadDatoActividadPrincipal(LocalDate fechaInicio, LocalDate fechaFinal, LocalDate fechaRegistro) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
    }
}
