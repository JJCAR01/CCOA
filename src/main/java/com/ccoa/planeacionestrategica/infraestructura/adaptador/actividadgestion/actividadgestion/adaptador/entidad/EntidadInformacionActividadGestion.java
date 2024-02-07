package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@Table(name = "informacion_actividades_gestion")
public class EntidadInformacionActividadGestion {

    @Id
    @Column(name = "id_informacion_actividad_gestion")
    private Long idInformacionActividadGestion;

    private Integer duracion;

    @Column(name = "dias_restantes")
    private Integer diasRestantes;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "iporcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    public EntidadInformacionActividadGestion(Integer duracion, Integer diasRestantes, Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
