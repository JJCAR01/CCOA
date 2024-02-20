package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "informacion_actividades_estrategicas")
public class EntidadInformacionActividadEstrategica{
    @Id
    @Column(name = "id_informacion_actividad_estrategica")
    private Long idInformacionActividadEstrategica;

    private Integer duracion;

    @Column(name = "dias_restantes")
    private Integer diasRestantes;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "porcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    @Column(name = "porcentaje_pat")
    private Double porcentajePat;


    public EntidadInformacionActividadEstrategica(Integer duracion, Integer diasRestantes, Double porcentajeReal,
                                                  Double porcentajeEsperado, Double porcentajeCumplimiento, Double porcentajePat) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
        this.porcentajePat = porcentajePat;
    }
}
