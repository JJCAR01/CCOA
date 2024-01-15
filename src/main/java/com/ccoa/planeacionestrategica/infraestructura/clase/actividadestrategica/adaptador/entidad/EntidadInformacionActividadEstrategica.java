package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "informacion_actividad_estrategica")
public class EntidadInformacionActividadEstrategica{
    @Id
    @Column(name = "id_informacion_actividad_estrategica")
    private Long idInformacionActividadEstrategica;

    private Integer duracion;

    @Column(name = "dias_restantes")
    private Integer diasRestantes;

    private Boolean estado;
    private Double avance;

    @JoinColumn(name = "id_pat")
    private Long idPat;
    @JoinColumn(name = "id_usuario")
    private Long idUsuario;


    public EntidadInformacionActividadEstrategica(Integer duracion, Integer diasRestantes, Boolean estado, Double avance, Long idPat, Long idUsuario) {
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.estado = estado;
        this.avance = avance;
        this.idPat = idPat;
        this.idUsuario = idUsuario;
    }
}
