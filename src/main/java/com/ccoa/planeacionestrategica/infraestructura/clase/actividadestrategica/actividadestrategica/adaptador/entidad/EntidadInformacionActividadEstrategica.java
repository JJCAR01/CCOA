package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.actividadestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "informacion_actividad_estrategica")
public class EntidadInformacionActividadEstrategica{
    @Id
    @Column(name = "id_informacion_actividad_estrategica")
    private Long idInformacionActividadEstrategica;

    private Integer duracion;

    @Column(name = "dias_restantes")
    private Integer diasRestantes;

    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double porcentajeCumplimiento;

    public EntidadInformacionActividadEstrategica(Integer duracion, Integer diasRestantes, Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
