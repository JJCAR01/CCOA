package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    @JoinColumn(name = "id_usuario")
    private Long idUsuario;


    public EntidadPat(String nombre, Integer fechaAnual, LocalDate fechaRegistro, Double porcentaje, EProceso proceso, Long idUsuario) {
        this.nombre = nombre;
        this.fechaAnual = fechaAnual;
        this.fechaRegistro = fechaRegistro;
        this.porcentaje = porcentaje;
        this.proceso = proceso;
        this.idUsuario = idUsuario;
    }

}
