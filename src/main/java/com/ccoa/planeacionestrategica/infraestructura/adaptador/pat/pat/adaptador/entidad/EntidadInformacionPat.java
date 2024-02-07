package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proceso.adaptador.entidad.EntidadProceso;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "informacion_pats")
public class EntidadInformacionPat {

    @Id
    @Column(name = "id_informacion_pat")
    private Long idInformacionPat;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_proceso")
    private EntidadProceso proceso;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_direccion")
    private EntidadDireccion direccion;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "iporcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    public EntidadInformacionPat(EntidadProceso proceso, EntidadDireccion direccion, Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.proceso = proceso;
        this.direccion = direccion;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}