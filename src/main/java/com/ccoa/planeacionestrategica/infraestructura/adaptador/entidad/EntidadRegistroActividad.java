package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "registro_actividad")
public class EntidadRegistroActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_registro_actividad")
    private Long idRegistroActividad;



    @JoinColumn(name = "actividad_principal_id")
    private Long idActividadPrincipal;
}

