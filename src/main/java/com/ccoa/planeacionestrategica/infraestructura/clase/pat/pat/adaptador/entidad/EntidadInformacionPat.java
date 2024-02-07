package com.ccoa.planeacionestrategica.infraestructura.clase.pat.pat.adaptador.entidad;

import com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.clase.proceso.adaptador.entidad.EntidadProceso;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "informacion_pat")
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

    private Double porcentajeReal;
    private Double porcentajeEsperado;
    private Double porcentajeCumplimiento;

    public EntidadInformacionPat(EntidadProceso proceso, EntidadDireccion direccion, Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento) {
        this.proceso = proceso;
        this.direccion = direccion;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
    }
}
