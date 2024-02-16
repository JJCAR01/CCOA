package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proceso.adaptador.entidad.EntidadProceso;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "informacion_pats")
public class EntidadInformacionPat {

    @Id
    @Column(name = "id_informacion_pat")
    private Long idInformacionPat;

    /*CascadeType.PERSIST para que no elimine lo que tenga que ver con las clases hijas,
    CascadeType.ALL, eliminaria */
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_proceso")
    private EntidadProceso proceso;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_direccion")
    private EntidadDireccion direccion;

    @Column(name = "porcentaje_real")
    private Double porcentajeReal;

    @Column(name = "porcentaje_esperado")
    private Double porcentajeEsperado;

    @Column(name = "porcentaje_cumplimiento")
    private Double porcentajeCumplimiento;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    public EntidadInformacionPat(EntidadProceso proceso, EntidadDireccion direccion, Double porcentajeReal,
                                 Double porcentajeEsperado, Double porcentajeCumplimiento, LocalDate fechaInicial, LocalDate fechaFinal) {
        this.proceso = proceso;
        this.direccion = direccion;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public EntidadInformacionPat(Long idInformacionPat, EntidadProceso proceso, EntidadDireccion direccion, Double porcentajeReal, Double porcentajeEsperado, Double porcentajeCumplimiento, LocalDate fechaInicial, LocalDate fechaFinal) {
        this.idInformacionPat = idInformacionPat;
        this.proceso = proceso;
        this.direccion = direccion;
        this.porcentajeReal = porcentajeReal;
        this.porcentajeEsperado = porcentajeEsperado;
        this.porcentajeCumplimiento = porcentajeCumplimiento;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }
}
