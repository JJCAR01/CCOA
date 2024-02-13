package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "informacion_actividades_gestion_estrategicas")
public class EntidadInformacionActividadGestionEstrategica {

    @Id
    @Column(name = "id_informacion_actividad_gestion_estrategica")
    private Long idInformacionActividadGestionEstrategica;

    private Integer duracion;

    @Column(name = "dias_restantes")
    private Integer diasRestantes;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "porcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    public EntidadInformacionActividadGestionEstrategica(Integer duracion, Integer diasRestantes,
                                                         Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }

    public EntidadInformacionActividadGestionEstrategica(Long idInformacionActividadGestionEstrategica, Integer duracion, Integer diasRestantes,
                                                         Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.idInformacionActividadGestionEstrategica = idInformacionActividadGestionEstrategica;
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
