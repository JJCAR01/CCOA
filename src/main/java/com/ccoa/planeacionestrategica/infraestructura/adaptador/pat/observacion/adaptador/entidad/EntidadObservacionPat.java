package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.observacion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "observaciones_pat")
public class EntidadObservacionPat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_observacion_pat")
    private Long idObservacionPat;

    @Column(name = "id_pat")
    private Long idPat;

    private LocalDate fecha;
    private String descripcion;

    public EntidadObservacionPat(Long idPat, LocalDate fecha, String descripcion) {
        this.idPat = idPat;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

}
