package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "iporcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    private Integer meta;
    private String resultado;

    public EntidadInformacionActividadEstrategica(Integer duracion, Integer diasRestantes,
                                                  Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento, Integer meta, String resultado) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
        this.meta = meta;
        this.resultado = resultado;
    }
}
