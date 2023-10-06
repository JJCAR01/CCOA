package com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.enums.ETipoActividad;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "actividad")
public class EntidadActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad")
    private Long idActividad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETipoActividad tipoActividad;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "id_informacion_actividad")
    private Long idInformacionActividad;

    public EntidadActividad(ETipoActividad tipoActividad, LocalDate fechaInicial, LocalDate fechaFinal, Long idInformacionActividad) {
        this.tipoActividad = tipoActividad;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idInformacionActividad = idInformacionActividad;
    }
}
