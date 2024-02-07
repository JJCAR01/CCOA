package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "informacion_actividad_gestion_actividad_estrategica")
public class EntidadInformacionActividadGestionActividadEstrategica {

    @Id
    @Column(name = "id_informacion_actividad_gestion_actividad_estrategica")
    private Long idInformacionActividadActividadEstrategica;

    private Integer duracion;

    @Column(name = "dias_restantes")
    private Integer diasRestantes;

    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double porcentajeCumplimiento;

    public EntidadInformacionActividadGestionActividadEstrategica(Integer duracion, Integer diasRestantes,
                                                                  Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
