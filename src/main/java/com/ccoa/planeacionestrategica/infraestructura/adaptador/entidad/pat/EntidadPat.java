package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.pat;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.pat.enums.EProceso;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pat")
public class EntidadPat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pat")
    private Long idPat;

    @Column(unique = true)
    private String nombre;

    @Column( name = "fecha_anual")
    private Integer fechaAnual;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    private Double porcentaje;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EProceso proceso;

    @JoinColumn(name = "usuario_id")
    private Long idUsuario;

    public EntidadPat() {
    }

    public EntidadPat(String nombre, Integer fechaAnual, LocalDate fechaRegistro, Double porcentaje, String proceso, Long idUsuario) {
        this.nombre = nombre;
        this.fechaAnual = fechaAnual;
        this.fechaRegistro = fechaRegistro;
        this.porcentaje = porcentaje;
        this.proceso = EProceso.valueOf(proceso);
        this.idUsuario = idUsuario;
    }
}
