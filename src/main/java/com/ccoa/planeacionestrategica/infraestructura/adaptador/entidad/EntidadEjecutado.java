package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "ejecutado")
public class EntidadEjecutado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name = "usuario_id")
    private Long idUsuario;

    @JoinColumn(name = "actividad_principal_id")
    private Long idActividadPrincipal;
}
